package gr.uom.demo1.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import gr.uom.demo1.models.Course;
import gr.uom.demo1.models.Student;

@Service
public class CourseService {

	ArrayList<Course> list = new ArrayList<>();

	public void addCourses() {
		list.add(new Course("Spring", "Nikos", 8));
	}
	
	public ArrayList<Course> getAllCourses(){
		return list;
	}
}
