package com.example.Presidential.Elections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password hashing
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        allowStartPage(http);

        return http.build();
    }

    private void allowStartPage(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Permit access to these pages without authentication
                .requestMatchers("/", "/login", "/process-login", "/profile",
                                 "/register", "/adduser", "style.css", "script.js")
                .permitAll()
    
                // Allow access to '/becomeCandidate' only for authenticated users
                .requestMatchers("/becomeCandidate").authenticated() // Ensures the user is authenticated
    
                // Alternatively, restrict '/becomeCandidate' to users with a specific role, e.g., 'ROLE_USER'
                //.requestMatchers("/becomeCandidate").hasRole("USER")
    
                // Require authentication for all other endpoints
                .anyRequest().authenticated()
            );
    }

    
}