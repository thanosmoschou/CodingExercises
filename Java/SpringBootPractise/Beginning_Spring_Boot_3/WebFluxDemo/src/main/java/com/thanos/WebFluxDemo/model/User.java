package com.thanos.WebFluxDemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

// We do not use JPA. You have to create the tables manually, or use data.sql and schema.sql

@Table("users")
public class User implements Persistable<Integer> {
    @Id
    private Integer id;
    private String name;
    private int age;

    @Transient // This tells Spring that this field should not be stored in the db
    private boolean isNewEntry = true; // When a user object is created this attribute is true

    public User() {
    }

    // JSON will not use this constructor when binding json data to user objects.
    // It will use setters. So in our case isNewEntry needs to be set to false manually.
    public User(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isNewEntry = false;
    }

    @Override
    public boolean isNew() {
        return this.id == null || isNewEntry;
    }

    public void setNew(boolean isNew) {
        this.isNewEntry = isNew;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
