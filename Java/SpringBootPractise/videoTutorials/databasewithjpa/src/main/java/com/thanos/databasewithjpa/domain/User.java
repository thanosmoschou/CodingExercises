package com.thanos.databasewithjpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * What is an entity?
 * 
 * In the context of Java Persistence API (JPA) and Spring Data JPA, an entity is a lightweight, 
 * persistent domain object that represents a table in a relational database. Each entity instance corresponds 
 * to a row in the table, and each entity field corresponds to a column in that table. 
 * 
 * Key Characteristics of an Entity: 
 * 
 * Annotation: 
 * An entity is typically annotated with the @Entity annotation, which indicates that the class is a JPA entity and should be mapped to a database table.
 * 
 * Primary Key:
 * Every entity must have a primary key, which uniquely identifies each record in the table. 
 * This is specified using the @Id annotation. The primary key can be generated automatically by the database using the @GeneratedValue annotation.
 * 
 * Mapping Fields to Columns: 
 * By default, each field in the entity class is mapped to a column in the table. You can customize this mapping using the @Column annotation.
 * 
 * Relationships:
 * Entities can have relationships with other entities, such as one-to-one, one-to-many, many-to-one, and many-to-many relationships. 
 * These relationships are defined using annotations like @OneToOne, @OneToMany, @ManyToOne, and @ManyToMany.
 * 
 * Lifecycle: 
 * Entities have a lifecycle that is managed by the JPA EntityManager. This lifecycle includes states such as new, managed, detached, and removed.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User 
{
    @Id
    private String name;
    private int age;

    public void printInfo()
    {
    	System.out.println("Name: " + this.name + " Age: " + this.age);
    }
}
