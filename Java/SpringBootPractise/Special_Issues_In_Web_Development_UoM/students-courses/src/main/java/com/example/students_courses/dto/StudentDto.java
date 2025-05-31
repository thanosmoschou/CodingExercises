package com.example.students_courses.dto;

import java.util.List;

public class StudentDto {
	private String name;
	private List<String> courses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
	
}
