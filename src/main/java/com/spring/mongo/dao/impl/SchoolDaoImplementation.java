package com.spring.mongo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mongo.bean.School;
import com.spring.mongo.dao.SchoolDao;
import com.spring.mongo.repositories.SchoolRepository;

@Repository
public class SchoolDaoImplementation implements SchoolDao
{
    @Autowired
    SchoolRepository repo;

	@Override
	public School add(School bean) {
	
		return repo.save(bean);
	}

	@Override
	public List<School> getAll() {
		
		return repo.findAll();
	}

	@Override
	public School update( School bean) {
		
		return repo.save(bean);
	}

	@Override
	public void deleteById(String schoolId) {
		repo.deleteById(schoolId);
		
	}

	@Override
	public School getById(String schoolId) {
		
		return repo.findById(schoolId).orElse(null);
	}

	
}
