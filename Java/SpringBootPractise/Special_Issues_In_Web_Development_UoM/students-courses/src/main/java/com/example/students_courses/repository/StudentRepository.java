package com.example.students_courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.students_courses.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
