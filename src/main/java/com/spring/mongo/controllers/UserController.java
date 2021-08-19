package com.spring.mongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.bean.School;
import com.spring.mongo.bean.User;
import com.spring.mongo.services.UserService;

import io.swagger.annotations.Api;

@RestController

public class UserController 
{
   @Autowired
   UserService service;
   
   @PostMapping("/signup")
   public ResponseEntity<User> addUser(@RequestBody User bean) throws Exception 
   {
	   boolean wer=service.existsByUsername(bean.getUserName());  
       User user=service.add(bean,wer);
	   return ResponseEntity.ok(user);
   }
	
   @GetMapping("/all")
   public ResponseEntity<List<User>> getUser()
   {
	  List<User> user=service.getAll();
	  return ResponseEntity.ok(user);
   }
   
   @DeleteMapping("/delete/{id}")
   public void deleteUser(@PathVariable String id)
   {
	 service.deleteById(id);
   }
   
   @PutMapping("/update/{id}")
   public ResponseEntity<User> updateUser(@RequestBody User bean,@PathVariable String id) 
   {
	  User user=service.update(id,bean);
	  return ResponseEntity.ok(user);
   }
   
   @GetMapping("/user/{id}")
   public ResponseEntity<User> getById(@PathVariable String id)
   {
	   User user=service.getById(id);
	   return ResponseEntity.ok(user);
   }
   
//   @PostMapping("/{id}")
//   public ResponseEntity<User> addUserToSchoolId(@RequestBody User bean,@PathVariable String id)
//   {
//	   User user=service.addUserToSchoolId(id,bean);
//	   return ResponseEntity.ok(user);
//   }
//   
   @GetMapping("/school/{schoolId}")
   public ResponseEntity<List<User>> getBySchoolId(@PathVariable String schoolId)
   { 
	   List<User> user=service.getBySchoolId(schoolId);
	   return ResponseEntity.ok(user);
   }
}
