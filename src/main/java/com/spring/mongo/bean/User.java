package com.spring.mongo.bean;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	private String id;
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private School school;
	
//	public String getSchoolId() {
//		return schoolId;
//	}
//	public void setSchoolId(String schoolId) {
//		this.schoolId = schoolId;
//	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}

	
}
