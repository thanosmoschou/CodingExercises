package gr.uom.demo1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.uom.demo1.controllers.dto.StudentStripped;
import gr.uom.demo1.models.Course;
import gr.uom.demo1.models.Student;
import gr.uom.demo1.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired CourseService courseService;

	
	@GetMapping("/gettmpcourses")
	public List<Course> getTmpStudents(){
		return courseService.getAllCourses();
	}
	
}
