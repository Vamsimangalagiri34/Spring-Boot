package com.API.APIGateWay.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

    private  String adminUsername="vamsi";
    private  String adminPassword="vamsi123";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/public/**").permitAll()
                        .requestMatchers("/api/admin/**").hasRole("EXTREM_ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // ✅ Use Customizer for modern configuration

        return httpSecurity.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails adminUser = User.withUsername("vamsi")
                .password(passwordEncoder().encode("vamsi123"))
                .roles("ADMIN")
                .build();

        UserDetails superadminUser = User.withUsername("vamsi_super")
                .password(passwordEncoder().encode("vamsi123"))
                .roles("SUPER_ADMIN","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(adminUser, superadminUser);
    }

}
