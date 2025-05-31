package com.example.students_courses.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.students_courses.dto.CourseDto;
import com.example.students_courses.dto.CourseEnrollDto;
import com.example.students_courses.dto.StudentDto;
import com.example.students_courses.model.Course;
import com.example.students_courses.model.StatusCode;
import com.example.students_courses.model.Student;
import com.example.students_courses.repository.CourseRepository;
import com.example.students_courses.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public StatusCode addCourse(CourseDto courseDto) {
		Course course = new Course();
		course.setName(courseDto.getName());
		course.setStudents(new ArrayList<>());
		
		courseRepository.save(course);
		
		return StatusCode.SUCCESS;
	}
	
	public List<CourseDto> getCourses() {
		List<Course> courses = courseRepository.findAll();
		
		return courses.stream().map(course -> {
			CourseDto dto = new CourseDto();
			dto.setName(course.getName());
			
			List<String> students = course.getStudents().stream().map(student -> student.getName()).toList();
			
			dto.setStudents(students);
			
			return dto;
		}).collect(Collectors.toList());
	}
	
	public List<StudentDto> getStudents(String courseId) {
		Course c = courseRepository.findById(Long.parseLong(courseId)).get();
		
		return c.getStudents().stream().map(student -> {
			StudentDto dto = new StudentDto();
			dto.setName(student.getName());
			
			return dto;
		}).collect(Collectors.toList());
	}
	
	public StatusCode enrollStudent(CourseEnrollDto cDto) {
		Course c = courseRepository.findById(Long.parseLong(cDto.getCourseId())).get();
		Student s = studentRepository.findById(Long.parseLong(cDto.getStudentId())).get();
		
		c.getStudents().add(s);
		s.getCourses().add(c);
		
		courseRepository.save(c);
		studentRepository.save(s);
		
		return StatusCode.SUCCESS;
	}
}
