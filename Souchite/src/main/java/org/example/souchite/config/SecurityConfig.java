package org.example.souchite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // Bean pour encoder les mots de passe (toujours utile)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Désactive toute forme de sécurité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()                      // désactive la protection CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()          // autorise tout le monde à tout
                )
                .formLogin().disable()                 // désactive le formulaire de login
                .httpBasic().disable();                // désactive l'authentification basique
        return http.build();
    }
}
