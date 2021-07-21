package com.mniemann.springboot.security.config;

import static com.mniemann.springboot.security.config.UserRole.ADMIN;
import static com.mniemann.springboot.security.config.UserRole.STUDENT;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity // this is the place where we configure everything about security
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/", "index", "/css/*", "/js/*")
        .permitAll()
        .antMatchers("/api/**")
        .hasRole(STUDENT.name())
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
  }

  @Override
  @Bean // will be instantiated automatically
  protected UserDetailsService userDetailsService() {
    UserDetails user =
        User.builder()
            .username("markus")
            .password(passwordEncoder.encode("password"))
            .roles(STUDENT.name())
            .build();

    UserDetails admin =
        User.builder()
            .username("admin")
            .password(passwordEncoder.encode("geheim"))
            .roles(ADMIN.name())
            .build();

    return new InMemoryUserDetailsManager(user, admin);
  }
}
