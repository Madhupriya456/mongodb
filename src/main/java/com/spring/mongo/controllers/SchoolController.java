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

import com.spring.mongo.services.SchoolService;

@RestController

public class SchoolController 
{
	  @Autowired
	  SchoolService service;
	  
      @PostMapping("/one")
      public ResponseEntity<School> addSchool(@RequestBody School bean)
      {
    	  School school=service.add(bean);
    	  return ResponseEntity.ok(school);
      }
      
      @GetMapping("/getall")
      public ResponseEntity<List<School>> getSchool()
      {
    	 List<School> school=service.getAll();
    	  return ResponseEntity.ok(school);
      }
      
      @PutMapping("/{schoolId}")
      public ResponseEntity<School> updateSchool(@RequestBody School bean,@PathVariable String schoolId)
      {
    	  School school=service.update(schoolId,bean);
    	  return ResponseEntity.ok(school);
      }
      
      @DeleteMapping("/{schoolId}")
     public void deleteSchool(@PathVariable String schoolId)
      {
    	  service.deleteById(schoolId);
      }
      
      @GetMapping("/{schoolId}")
      public ResponseEntity<School> getById(@PathVariable String schoolId)
      {
    	 School school=service.getById(schoolId);
    	  return ResponseEntity.ok(school);
      }
     
      
      
     
}
