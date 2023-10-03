//package com.example.billingbackend.Security;
//
//import java.security.ProtectionDomain;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.authorization.AuthoritiesAuthorizationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
//@EnableWebSecurity
//public class MyConfig extends WebSecurityConfiguration{
//	@Bean
//	public UserDetailsService getDetailsService () {
//		  
//		return new UserDeatilsServiceImpl();
//	}
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//		
//	}
//	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		
//		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
//		
//		daoAuthenticationProvider.setUserDetailsService(this.getDetailsService());
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//		
//		return daoAuthenticationProvider;
//;		
//	}
//	
//	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		
//		auth.authenticationProvider(authenticationProvider());
//	}
//	
//
//
//}
