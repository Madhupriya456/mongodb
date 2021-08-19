package com.spring.mongo.dao;

import java.util.List;

import com.spring.mongo.bean.School;

public interface SchoolDao 
{

	School add(School bean);

	List<School> getAll();

	void deleteById(String schoolId);

	School getById(String schoolId);

	School update(School school);

	

}
