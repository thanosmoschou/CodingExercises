package com.thanos.demo1.services;

import com.thanos.demo1.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> studentList = new ArrayList<>();

    public void addStudent() {
        Student s1 = new Student("Thanos", 21, "1234");
        Student s2 = new Student("Makis", 24, "4567");

        studentList.add(s1);
        studentList.add(s2);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

}
