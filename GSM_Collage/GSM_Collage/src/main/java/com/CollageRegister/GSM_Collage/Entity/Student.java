package com.CollageRegister.GSM_Collage.Entity;

public class Student {
	private String name ;
	private String email;
	private String course;
	
	
	public Student() {
		super();
	}
	public Student(String name, String email, String course) {
		super();
		this.name = name;
		this.email = email;
		this.course = course;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", course=" + course + "]";
	}
	
	

}
