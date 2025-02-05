/*
 * Author: Thanos Moschou
 * Description: This is a simple rest api. This is based on devtiro's rest api tutorial
 * but I make a people api instead of books.
 */

package com.thanos.person.services;

import java.util.List;
import java.util.Optional;

import com.thanos.person.domain.Person;

public interface PersonService {
	public void create(Person person);

	public Person read(String id);
	
	public List<Person> readAll();

	public void update(Person person);

	public void delete(String id);
}
