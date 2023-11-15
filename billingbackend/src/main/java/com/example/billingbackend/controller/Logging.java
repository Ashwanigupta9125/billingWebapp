package com.example.billingbackend.controller;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billingbackend.Security.JwtHelper;
import com.example.billingbackend.Security.JwtRequest;
import com.example.billingbackend.Security.JwtResponse;
import com.example.billingbackend.entities.Products;


@CrossOrigin
@RestController
@RequestMapping("/public")
public class Logging {

	
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(Logging.class);

	
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

    	System.err.println(request.getEmail() +"      xxxxxxxxxxxxx      "+request.getPassword());
        this.doAuthenticate(request.getEmail(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);

//        JwtResponse response = JwtResponse.builder()
//                .jwtToken(token)
//                .username(userDetails.getUsername()).build();
        
        JwtResponse response =new JwtResponse(token,userDetails.getUsername());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@GetMapping("/test")
	private String index() {
	
		System.out.print("Method is stared.............");
 
		return "Request completed...xxxx.....";
		
		
	}
	
	@GetMapping("/check01")
	public String check01() {
		
		System.out.print("runnig check01..........................");
		
		return "Request completed...xxxx..yyyyy...";
	}

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
	
}
