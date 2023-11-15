package com.example.billingbackend.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import io.jsonwebtoken.Header;




@Configuration
public class SecurityConfig {


    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    	
        http.csrf(csrf -> csrf.disable())
        .cors(cors ->cors.getClass())
            .authorizeHttpRequests(
            		 auth->
            		 auth.requestMatchers("/lock/**").authenticated().requestMatchers("/public/login").permitAll().anyRequest().authenticated())
                         .exceptionHandling( ex-> ex.authenticationEntryPoint(point))
                         .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        
         return http.build();
            
               
    }


}