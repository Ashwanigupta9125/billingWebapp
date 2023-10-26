package com.example.billingbackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication()
public class BillingbackendApplication {
	

	public static void main(String[] args) {
		
		SpringApplication.run(BillingbackendApplication.class, args);         

	}
	
	
	
	



   
	
}
