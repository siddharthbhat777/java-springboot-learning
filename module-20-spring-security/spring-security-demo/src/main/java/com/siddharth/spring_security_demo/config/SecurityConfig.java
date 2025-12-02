package com.siddharth.spring_security_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        //Imperative style
        /*Customizer<CsrfConfigurer<HttpSecurity>> customizeCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> configurer) {
                configurer.disable();
            }
        };
        http.csrf(customizeCsrf);
        // Lambda way -> http.csrf(customizer -> customizer.disable());

        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> customizerHttp = new Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
            @Override
            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
                registry.anyRequest().authenticated();
            }
        };
        http.authorizeHttpRequests(customizerHttp);
        // Lambda way -> http.authorizeHttpRequests(request -> request.anyRequest().authenticated());*/

        // Lambda style
        /*http.csrf(customizer -> customizer.disable()); // disabling csrf
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated()); // enabling security for requests
        http.httpBasic(Customizer.withDefaults()); // added default http settings
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // making session stateless*/

        // Builder pattern way
        http
                .csrf(customizer -> customizer.disable()) // disabling csrf
                .authorizeHttpRequests(request -> request.anyRequest().authenticated()) // enabling security for requests
                .httpBasic(Customizer.withDefaults()) // added default http settings
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // making session stateless

        return http.build();
    }
}
