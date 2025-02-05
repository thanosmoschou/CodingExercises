/*
 * Author: Thanos Moschou
 * Description: This is a simple rest api. This is based on devtiro's rest api tutorial
 * but I make a people api instead of books.
 */

package com.thanos.person.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This class is annotated with @Entity which means that this class
 * is a JPA entity.
 * 
 * The @Table annotation tells Spring that this entity maps to a people table inside our database.
 * The @Id is to specify the entity's primary key.
 * 
 * Entity is used to save and retrieve via JPA.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity //This is for the JPA
@Table(name = "people")
public class Person 
{
	@Id
	private String id;
	private String name;
	private int age;
}
