package com.example.students_courses.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.students_courses.dto.CourseDto;
import com.example.students_courses.dto.StudentDto;
import com.example.students_courses.model.StatusCode;
import com.example.students_courses.model.Student;
import com.example.students_courses.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public StatusCode addStudent(StudentDto studentDto) {
		Student student = new Student();
		student.setName(studentDto.getName());
		student.setCourses(new ArrayList<>());
		
		studentRepository.save(student);
		
		return StatusCode.SUCCESS;
	}
	
	public List<StudentDto> getAllStudents() {
		return studentRepository.findAll().stream().map(student -> {
			StudentDto dto = new StudentDto();
			dto.setName(student.getName());
			
			List<String> coursesOfThisStudent = student.getCourses().stream().map(course -> course.getName()).toList();
			
			dto.setCourses(coursesOfThisStudent);
			
			return dto;
		}).collect(Collectors.toList());
	}
	
	public List<CourseDto> getStudentsCourses(String studentId) {
		Student s = studentRepository.findById(Long.parseLong(studentId)).get();
		
		return s.getCourses().stream().map(course -> {
			CourseDto dto = new CourseDto();
			dto.setName(course.getName());
						
			return dto;
		}).collect(Collectors.toList());
	}

}
