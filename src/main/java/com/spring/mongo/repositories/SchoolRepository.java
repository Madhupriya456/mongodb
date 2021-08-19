package com.spring.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.bean.School;

public interface SchoolRepository extends MongoRepository<School, String>{

	

}
