package com.mfigueroa.mutants.infrastructure.controller;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RestController;

@EnableResourceServer
@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.cors().and()
                // Allows to consult the token
                .authorizeRequests().antMatchers("/oauth/token").permitAll();
        http.requestMatchers().antMatchers("/stats", "/mutant").and().authorizeRequests().anyRequest().access("hasRole ('USER')");

    }

}
