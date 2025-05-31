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
import com.example.students_courses.dto.StudentDto;
import com.example.students_courses.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addStudent(@RequestBody StudentDto studentDto) {
		studentService.addStudent(studentDto);
		
		return ResponseEntity.ok().body("Student added successfully");
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<StudentDto>> getAllStudents() {
		return ResponseEntity.ok().body(studentService.getAllStudents());
	}
	
	@GetMapping("/{studentId}/courses")
	public ResponseEntity<List<CourseDto>> getStudentsCourses(@PathVariable String studentId) {
		return ResponseEntity.ok().body(studentService.getStudentsCourses(studentId));
	}
}
