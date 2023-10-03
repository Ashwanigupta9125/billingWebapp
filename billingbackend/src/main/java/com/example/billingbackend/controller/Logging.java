package com.example.billingbackend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class Logging {

	
	@GetMapping("/log")
	private String  Privtae() {
		// TODO Auto-generated method stub
		
		return "Hello user";

	}
	
}
