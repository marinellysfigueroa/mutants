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
    public void configure(HttpSecurity http) throws Exception {

        // TODO
        http.cors().and()
                // Allows to consult the token
                // .authorizeRequests().antMatchers("/oauth/token", "/mutant","/stats").permitAll()
                .authorizeRequests().antMatchers("/oauth/token", "/mutant","/stats").permitAll();
        // Request authorization to consult mutants and stat
        // http.requestMatchers().antMatchers("/stats").and().authorizeRequests().anyRequest().access("hasRole ('USER')");

    }

}
