package com.spring.mongo.repositories;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.mongo.bean.School;
import com.spring.mongo.bean.User;

public interface UserRepository extends MongoRepository<User,String>{

//	  @Query(value="{username: ?0,password: ?1}",exists= true)
//  	boolean existsByUsernamePassword(String username, String password);
      
	  @Query(value="{userName: ?0}",exists= true)
	  	boolean existsByUsername(String userName);

//	   @Query("{schoolId: ?0}")
//	    List<User> findAllBySchoolId(String schoolId);

	   @Query("{userName: ?0,password: ?1}")
	    User findByUsernameAndPassword(String userName, String password);
	   
       @Query("{userName: ?0}")
	   User findByUserName(String userName);

       @Query("{'School.schoolId': ?0}")
	List<User> findAllBySchoolId(String schoolId);

	

	

	

	
}
  