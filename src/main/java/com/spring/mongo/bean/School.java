package com.spring.mongo.bean;

import org.springframework.data.annotation.Id;

public class School 
{
	@Id
   private String schoolId;
   private String schoolName;
   private String place;
   
public String getSchoolId() {
	return schoolId;
}
public void setSchoolId(String schoolId) {
	this.schoolId = schoolId;
}
public String getSchoolName() {
	return schoolName;
}
public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
}
public String getPlace() {
	return place;
}
public void setPlace(String place) {
	this.place = place;
}
   
   
   
}
