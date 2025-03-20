package com.thanos.demo1.controllers;

import com.thanos.demo1.model.Course;
import com.thanos.demo1.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getCourseList();
    }

    /*@GetMapping("/random")
    public Course getRandomCourse() {
        return new Course("Gymnastics", 4);
    }*/

    @GetMapping("/add")
    public void addCourse() {
        courseService.addCourse();
    }
}
