package com.thanos.demo1.config;

import com.thanos.demo1.services.CourseService;
import com.thanos.demo1.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner commandLineRunner(StudentService studentService, CourseService courseService) {
        return args -> {
          studentService.addStudent();
          courseService.addCourse();
        };
    }
}
