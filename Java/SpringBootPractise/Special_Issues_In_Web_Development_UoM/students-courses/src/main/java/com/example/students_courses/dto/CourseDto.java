package com.example.students_courses.dto;

import java.util.List;

public class CourseDto {
	private String name;
	private List<String> students;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getStudents() {
		return students;
	}

	public void setStudents(List<String> students) {
		this.students = students;
	}
	
	
	
}
