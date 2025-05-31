package com.example.students_courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.students_courses.dto.CourseDto;
import com.example.students_courses.dto.CourseEnrollDto;
import com.example.students_courses.dto.StudentDto;
import com.example.students_courses.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addCourse(@RequestBody CourseDto courseDto) {
		courseService.addCourse(courseDto);
		
		return ResponseEntity.ok().body("Course added successfully");
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CourseDto>> getCourses() {
		return ResponseEntity.ok().body(courseService.getCourses());
	}
	
	@GetMapping("/getStudents/{courseId}")
	public ResponseEntity<List<StudentDto>> getStudents(@PathVariable String courseId) {
		return ResponseEntity.ok().body(courseService.getStudents(courseId));
	}
	
	@PostMapping("/enroll")
	public ResponseEntity<String> enrollStudent(@RequestBody CourseEnrollDto courseDto) {
		courseService.enrollStudent(courseDto);
		
		return ResponseEntity.ok().body("Student enrolled");
	} 
}
