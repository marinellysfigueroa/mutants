package com.mfigueroa.mutants.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfigueroa.mutants.application.command.DnaCommand;
import com.mfigueroa.mutants.testdatabuilder.HumanDnaTestDataBuilder;
import com.mfigueroa.mutants.testdatabuilder.MutantDnaTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Locale;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class DnaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MessageSource messageSource;

    @Test
    public void addMutant() throws Exception{
        DnaCommand dnaCommand = new MutantDnaTestDataBuilder().buildCommand();
        mvc.perform( MockMvcRequestBuilders
                .post("/mutant")
                .content(objectMapper.writeValueAsString(dnaCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addHuman() throws Exception{
        DnaCommand dnaCommand = new HumanDnaTestDataBuilder().buildCommand();
        mvc.perform( MockMvcRequestBuilders
                .post("/mutant")
                .content(objectMapper.writeValueAsString(dnaCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    public void  nullSequence () throws Exception {

        System.out.println(messageSource.getMessage("dna.nullval.error", null, Locale.getDefault()));
        mvc.perform( MockMvcRequestBuilders
                .post("/mutant")
                .content(objectMapper.writeValueAsString(null))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void  emptySequence () throws Exception {
        String dna[] ={""};
        DnaCommand dnaCommand = new DnaCommand(dna);
        mvc.perform( MockMvcRequestBuilders
                .post("/mutant")
                .content(objectMapper.writeValueAsString(null))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void  notAllowedChartSequence () throws Exception {
        String dna[] ={"ACB","DEF","JKL"};
        DnaCommand dnaCommand = new DnaCommand(dna);
        mvc.perform( MockMvcRequestBuilders
                .post("/mutant")
                .content(objectMapper.writeValueAsString(null))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void  notNxNSequence () throws Exception {
        String dna[] ={"AAA","CCC"};
        DnaCommand dnaCommand = new DnaCommand(dna);
        mvc.perform( MockMvcRequestBuilders
                .post("/mutant")
                .content(objectMapper.writeValueAsString(null))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
