package com.mfigueroa.mutants.infrastructure;

import com.mfigueroa.mutants.infrastructure.config.AuthorizationServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthorizationServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthServerIntegrationTest {
    @Test
    public void whenLoadApplicationThenSuccess() {

    }
}
