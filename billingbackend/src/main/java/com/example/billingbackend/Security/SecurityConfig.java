//package com.example.billingbackend.Security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AnyRequestMatcher;
//
//import com.fasterxml.jackson.core.StreamReadConstraints.Builder;
//import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig  {
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
//		httpSecurity.csrf((csrf) -> csrf.disable() )
//		.authorizeHttpRequests()
//		.requestMatchers("/public/log")
//		.permitAll()
//		.anyRequest()
//		.authenticated().and()
//		.formLogin();
//		
//		return httpSecurity.build();
//		
//	}
//
//	 
//}