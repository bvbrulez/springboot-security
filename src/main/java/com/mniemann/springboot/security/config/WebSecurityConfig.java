package com.mniemann.springboot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // this is the place where we configure everything about security
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // whitelist for every single user should be able to get access to the
    // - root
    // - index
    // - css
    // - js -> permit all
    // any request must be authenticated with the basic auth mechanism

    http.authorizeRequests()
        .antMatchers("/", "index", "/css/*", "/js/*")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
  }
}
