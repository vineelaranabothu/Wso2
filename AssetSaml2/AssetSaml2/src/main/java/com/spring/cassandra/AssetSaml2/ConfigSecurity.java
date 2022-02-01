package com.spring.cassandra.AssetSaml2;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests(authz -> authz
                .antMatchers("/login").permitAll() 
                .anyRequest().authenticated())
                .saml2Login(saml2 -> saml2.loginPage("/login"));
    }

}