package com.almora.almora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigSecurity {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers(
                                                                "/", "/index.html", "/login.html", "/register.html",
                                                                "/css/**", "/js/**", "/img/**", "/api/usuarios/admin",
                                                                "/api/usuarios")
                                                .permitAll()

                                                .requestMatchers("/admin.html").hasRole("ADMIN")
                                                .requestMatchers("/donante.html").hasRole("DONANTE")

                                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/login.html")
                                                .loginProcessingUrl("/login")
                                                .defaultSuccessUrl("/api/usuarios/redirect", true)
                                                .failureUrl("/login.html?error=true")
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/login.html?logout=true"));

                return http.build();
        }
}