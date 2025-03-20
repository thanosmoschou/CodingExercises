package com.thanos.demo1.controllers.dto;

import com.thanos.demo1.services.StudentService;

// Only used to transfer data, only contains the necessary fields
public class StudentDTO {
    private String name;
    private int age;

    public StudentDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
