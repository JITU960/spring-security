package com.jk.springsecurity.authnauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterChainConfig {

    @Bean
    @Order(2)
    public SecurityFilterChain defaultSFC(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authManager -> authManager
            .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
            .requestMatchers("/h2-console/**").permitAll()
            .anyRequest().authenticated()
        );

        http.sessionManagement(
        configurer -> configurer.sessionCreationPolicy
                (SessionCreationPolicy.STATELESS));
//        http.formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    @Order(1)
    public SecurityFilterChain actuatorSFC(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests(authManager -> authManager
                        .requestMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated()
        );

        http.sessionManagement(
                configurer -> configurer.sessionCreationPolicy
                        (SessionCreationPolicy.STATELESS));
        http.formLogin(Customizer.withDefaults());
        return http.build();
    }

}
