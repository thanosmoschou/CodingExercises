package com.thanos.demo1.services;

import com.thanos.demo1.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Course> courseList = new ArrayList<>();

    public void addCourse() {
        courseList.add(new Course("Maths", 5));
        courseList.add(new Course("Literature", 4));
    }

    public List<Course> getCourseList() {
        return courseList;
    }
}
