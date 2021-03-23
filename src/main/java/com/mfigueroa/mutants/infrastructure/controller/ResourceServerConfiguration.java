package com.mfigueroa.mutants.infrastructure.controller;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@EnableResourceServer
@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure (HttpSecurity http) throws Exception {

        System.out.println("configure en ResourceServerConfiguration"+ http);

        http.cors().and()
       //Permite consultar el token
        .authorizeRequests (). antMatchers ("/oauth/token","/mutant").permitAll();
        // Solicita autorización para la consulta de mutantes y stat
        http.requestMatchers (). antMatchers ("/stats").and().authorizeRequests().anyRequest(). access ("hasRole ('USER')");

    }

}
