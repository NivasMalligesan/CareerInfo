package com.CodeSpace.careerinfo.config;

import com.CodeSpace.careerinfo.utils.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            JwtFilter jwtFilter
    ) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> {})
                .authorizeHttpRequests(auth -> auth

                        // ✅ Allow OPTIONS requests (for CORS preflight)
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                        // ✅ Allow auth endpoints without authentication
                        .requestMatchers("/auth/**").permitAll()

                        // ✅ Allow public access to skills and careers (for display)
                        .requestMatchers(HttpMethod.GET, "/api/skill/**", "/api/career/**").permitAll()

                        // ✅ Admin endpoints - ADMIN only
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")

                        // ✅ User and recommendations - USER and ADMIN can access
                        .requestMatchers("/api/user/**", "/api/recommendations/**", "/api/analysis/**")
                        .hasAnyRole("USER", "ADMIN")

                        // ✅ All other requests require authentication
                        .anyRequest().authenticated()
                )
                .addFilterBefore(
                        jwtFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
}