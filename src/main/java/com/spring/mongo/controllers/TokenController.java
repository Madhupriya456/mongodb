package com.spring.mongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.bean.Token;
import com.spring.mongo.bean.User;
import com.spring.mongo.services.UserService;
import com.spring.mongo.util.JwtUtil;


@RestController

public class TokenController 
{
	@Autowired
	JwtUtil util;
	
	@Autowired
	UserService service;
	
	@Autowired
    private AuthenticationManager authenticationManager;
//    boolean name=false;
//	 @PostMapping("/key")
//	   public ResponseEntity<String> addToken(@RequestBody User bean) throws Exception 
//	   {
//		   name=service.existsByUsernamePassword(bean.getUserName(),bean.getPassword());  
//	       service.token(name);
//		   return ResponseEntity.ok(service.token);
////	   }
//	 @PostMapping("/key")
//			public ResponseEntity<Token> getJwt(@RequestBody User bean) {
//			return ResponseEntity.ok(service.getToken(bean));
//		}
	
       
	 @GetMapping("/")
	    public String welcome() {
	        return "Welcome to javatechie !!";
	    }

	    @PostMapping("/authenticate")
	    public String generateToken(@RequestBody User bean) throws Exception {
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(bean.getUserName(), bean.getPassword())
	            );
	        } catch (Exception ex) {
	            throw new Exception("inavalid username/password");
	        }
	        return util.generateToken(bean.getUserName());
	    }
	}
