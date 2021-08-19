package com.spring.mongo.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.mongo.bean.School;
import com.spring.mongo.bean.User;
import com.spring.mongo.dao.UserDao;

import com.spring.mongo.repositories.UserRepository;
import com.spring.mongo.util.JwtUtil;



@Service
public class UserService implements UserDetailsService
{

	@Autowired
	UserRepository repo;
	@Autowired
	JwtUtil util;
	
    @Autowired
    UserDao dao;
    

  public String token=null;

	
	public List<User> getAll() {
		
		return dao.getAll();
	}

	public void deleteById(String id) {
         dao.deleteById(id);
		
	}

	public User update(String id, User bean){
		User user=getById(id);
	if(user!=null)
	{
		
		if(bean.getPassword()!=null)
			{
			  user.setPassword(bean.getPassword());
			}
		
		if(bean.getFirstName()!=null)
     		{
				user.setFirstName(bean.getFirstName());
			}
			if(bean.getLastName()!=null)
			{
				user.setLastName(bean.getLastName());
			}
			
		}		
		return dao.add(user);
	}

	public User add(User bean,boolean wer) throws Exception {
		User user=null;
		if(bean.getPassword()==null)
		{
			throw new Exception("password cant be null");
		}
		if(wer)
		{
			throw new Exception("username already exist");
		}
		else
		{
			user=dao.add(bean);	
		}
		return user;	 
	}

	public User getById(String id) {
		
		return dao.getById(id);
	}
//
//	public boolean existsByUsernamePassword(String userName, String password) {
//		return dao.existsByUsernamePassword(userName,password);
//		
//	}

//	public void token(boolean name) throws Exception {
//		if(name)
//		{
//			token=AuthFilter.SECRET_TOKEN;
//		}
//		else
//		{
//			throw  new Exception("please signup");
//		}		
//	}

	public boolean existsByUsername(String userName) {
		return dao.existsByUsername(userName);
	}

//	public User addUserToSchoolId(String id,User bean) {
//		User user=getById(id);
//		if(user.getSchoolId()!=null)
//		{
//			System.out.println("schoolid already exist");
//		}
//		else
//		{
//			user.setSchoolId(bean.getSchoolId());
//		}
//		return dao.add(user);
//	}

	public List<User> getBySchoolId(String schoolId) {
		
		return dao.getBySchoolId(schoolId);
	}

//	public Token getToken(User bean) {
//		User user = dao.getByUsernameAndPassword(bean.getUserName(), bean.getPassword());
//
//		Token resp = new Token();
//		if (user == null) {
//			resp.setToken("Please signup first");
//		} else {
//			resp.setToken(util.getToken(user));
//		}
//
//		return resp;
	//}
	
	  @Override
	    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	        User user = repo.findByUserName(userName);
	        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
	    }
}