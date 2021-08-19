package com.spring.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.bean.School;

import com.spring.mongo.dao.SchoolDao;

@Service
public class SchoolService 
{
    @Autowired
    SchoolDao dao;
	public School add(School bean) {
	
		return dao.add(bean);
	}
	public List<School> getAll() {
		
		return dao.getAll();
	}
	
	public School update(String schoolId, School bean) {
		School school=dao.getById(schoolId);
		if(school!=null)
		{
		if(bean.getSchoolName()!=null)
		{
		school.setSchoolName(bean.getSchoolName());
		}
		if(bean.getPlace()!=null)
		{
		school.setPlace(bean.getPlace());
		}
		}
			return dao.update(school);
	}
	

	public void deleteById(String schoolId) {
		dao.deleteById(schoolId);
		
	}
	public School getById(String schoolId) {
		
		return dao.getById(schoolId);
	}
	
	
   
}
