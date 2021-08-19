package com.spring.mongo.dao;

import java.util.List;

import com.spring.mongo.bean.School;
import com.spring.mongo.bean.User;

public interface UserDao {

	User add(User bean);

	List<User> getAll();

	User update(String userName, User bean);


	void deleteById(String id);

	User getById(String id);

//	boolean existsByUsernamePassword(String userName, String password);

	

	boolean existsByUsername(String userName);

	

	User getByUsernameAndPassword(String userName, String password);

	List<User> getBySchoolId(String schoolId);

	








	

	



}
