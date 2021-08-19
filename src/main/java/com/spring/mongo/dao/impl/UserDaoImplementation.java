package com.spring.mongo.dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mongo.bean.School;
import com.spring.mongo.bean.User;
import com.spring.mongo.dao.UserDao;
import com.spring.mongo.repositories.UserRepository;

@Repository
public class UserDaoImplementation implements UserDao {
	
	@Autowired
	UserRepository repo;
	
	public User add(User user)
	{
		return repo.save(user);		
	}

	@Override
	public List<User> getAll() {
		
		return repo.findAll();
	}


	@Override
	public User getById(String id) {
		
		return repo.findById(id).orElse(null);
	}
	@Override
	public void deleteById(String id) {
	repo.deleteById(id);
		
	}

	@Override
	public User update(String id, User bean) {
		
		return repo.save(bean);
	}

	
//	@Override
//	public boolean existsByUsernamePassword(String userName,String password) {
//		return repo.existsByUsernamePassword(userName,password);
//	}

	@Override

	public boolean existsByUsername(String userName) {
		return repo.existsByUsername(userName);
	}

	@Override
	public User getByUsernameAndPassword(String userName, String password) {
		
		return repo.findByUsernameAndPassword(userName, password);
	}

	@Override
	public List<User> getBySchoolId(String schoolId) {
		
		 return repo.findAllBySchoolId(schoolId);
	}

	
	
	
}
