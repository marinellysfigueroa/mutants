package com.mfigueroa.mutants.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfigueroa.mutants.application.command.DnaCommand;
import com.mfigueroa.mutants.infrastructure.config.AuthorizationServerApplication;
import com.mfigueroa.mutants.testdatabuilder.MutantDnaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = AuthorizationServerApplication.class)
@ActiveProfiles("mvc")
public class StatControllerTest {

    public static final String FRONT_APP_USER = "frontAppUser";
    public static final String FRONT_APP_PASSWORD = "]&$X@SKV*fg~%iyzF";
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private ObjectMapper objectMapper;


    private MockMvc mockMvc;

    private static final String CLIENT_ID = "angular-app";
    private static final String CLIENT_SECRET = "4ngul4rpass";
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilter(springSecurityFilterChain).build();
    }

    private String obtainAccessToken(String username, String password) throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", CLIENT_ID);
        params.add("username", username);
        params.add("password", password);

        // @formatter:off

        ResultActions result = mockMvc.perform(post("/oauth/token")
                .params(params)
                .with(httpBasic(CLIENT_ID, CLIENT_SECRET))
                .accept(CONTENT_TYPE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE));

        // @formatter:on

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

    @Test
    public void givenNoTokenWhenGetSecureRequestThenNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/stat")).andExpect(status().isNotFound());
    }

    @Test
    public void givenNoTokenWhenGetSecureRequestThenUnauthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/stats").header("Authorization", "Bearer XXXXX")).andExpect(status().isUnauthorized());
    }

    @Test
    public void getStat() throws Exception {
        final String accessToken = obtainAccessToken(FRONT_APP_USER, FRONT_APP_PASSWORD);

        // @formatter:off
        DnaCommand dnaCommand = new MutantDnaTestDataBuilder().buildCommand();


        mockMvc.perform(MockMvcRequestBuilders.get("/stats")
                .header("Authorization", "Bearer " + accessToken)
                .content(objectMapper.writeValueAsString(dnaCommand))
                .contentType(CONTENT_TYPE)
                .accept(CONTENT_TYPE))
                .andExpect(status().isOk());


        // @formatter:on
    }



}