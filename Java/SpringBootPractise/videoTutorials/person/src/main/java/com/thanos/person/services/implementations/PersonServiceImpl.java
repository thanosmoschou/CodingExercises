/*
 * Author: Thanos Moschou
 * Description: This is a simple rest api. This is based on devtiro's rest api tutorial
 * but I make a people api instead of books.
 */

package com.thanos.person.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thanos.person.domain.Person;
import com.thanos.person.repositories.PersonRepository;
import com.thanos.person.services.PersonService;

//@Service tells spring to put the implementation in the context.

@Service
public class PersonServiceImpl implements PersonService
{
	private final PersonRepository personRepository;
	
	public PersonServiceImpl(PersonRepository personRepository) 
	{
		this.personRepository = personRepository;
	}

	@Override
	public void create(Person person) 
	{	
		personRepository.save(person);
	}

	@Override
	public Person read(String id) 
	{
		return personRepository.findById(id).get();
	}
	
	@Override
	public List<Person> readAll() 
	{
		return personRepository.findAll();
	}

	@Override
	public void update(Person person) 
	{
		personRepository.save(person);
	}

	@Override
	public void delete(String id) 
	{
		personRepository.deleteById(id);		
	}
}
