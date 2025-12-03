package com.SpringSecurity.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity in this example
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll() // Allow all requests for now
            )
            .formLogin(form -> form
                .loginPage("/login") // Specify custom login page
                .permitAll()
            );
        return http.build();
    }
}

