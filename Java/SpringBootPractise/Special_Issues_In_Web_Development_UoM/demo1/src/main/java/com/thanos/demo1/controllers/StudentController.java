package com.thanos.demo1.controllers;

import com.thanos.demo1.controllers.dto.StudentDTO;
import com.thanos.demo1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    // You do not add business logic inside your controllers, instead you add a Service object

    @Autowired
    private StudentService studentService;

    /*
    // Constructor injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    */

    @GetMapping
    public List<StudentDTO> getStudents() {
        // Here you map the Student to StudentDTO. Not inside Service because it is not
        // business logic

        return studentService.getStudentList()
                .stream()
                .map(student -> new StudentDTO(student.getName(), student.getAge()))
                .collect(Collectors.toList());
    }

    /*@GetMapping("random")
    public Student getRandomStudent() {
        return new Student("Athanasioc", 20);
    }*/

    @GetMapping("/add")
    public void addStudent() {
        studentService.addStudent();
    }
}
