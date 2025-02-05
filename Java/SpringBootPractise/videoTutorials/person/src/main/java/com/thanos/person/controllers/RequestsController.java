/*
 * Author: Thanos Moschou
 * Description: This is a simple rest api. This is based on devtiro's rest api tutorial
 * but I make a people api instead of books.
 */

package com.thanos.person.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thanos.person.domain.Person;
import com.thanos.person.services.PersonService;


@RestController
public class RequestsController 
{
	private PersonService personService;

	public RequestsController(PersonService personService) 
	{
		this.personService = personService;
	}
	
	@PostMapping(path = "/person")
	public void createPerson(@RequestBody Person person)
	{
		personService.create(person);
	}
	
	@GetMapping(path = "/person/{id}")
	public Person read(@PathVariable String id)
	{
		return personService.read(id);
	}
	
	@GetMapping(path = "/person")
	public List<Person> realAll()
	{
		return personService.readAll();
	}
	
	@PutMapping(path = "/person/{id}")
	public void update(@RequestBody Person newPerson, @PathVariable String id) 
	{
		Person oldPerson = personService.read(id);
		oldPerson.setName(newPerson.getName());
		oldPerson.setAge(newPerson.getAge());
		personService.update(oldPerson);
	}

	@DeleteMapping(path = "/person/{id}")
	public void delete(@PathVariable String id) 
	{
		personService.delete(id);		
	}
}
