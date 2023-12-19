package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/customer/logon.html")
                .defaultSuccessUrl("/view1.html") // specify the default success URL
                .successHandler(webshopAuthenticationSuccessHandler) // use your custom success handler
                .and()
                .logout()
                .logoutSuccessUrl("/customer/home.html")
                .logoutUrl("/customer/j_spring_security_logout")
                .deleteCookies("remember-me")
                .permitAll()
                .and()
                .rememberMe()
                .and()
                .csrf().disable(); // disable CSRF protection for AJAX requests
    }

    // rest of the code
}