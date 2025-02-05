/*
 * Author: Thanos Moschou
 * Description: This is a simple rest api. This is based on devtiro's rest api tutorial
 * but I make a people api instead of books.
 */

package com.thanos.person.services.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.thanos.person.domain.Person;
import com.thanos.person.repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest
{
	@Mock
	private PersonRepository personRepository;
	@InjectMocks
	private PersonServiceImpl personServiceUnderTest;
	
	private Person p1;
	
	@Test
	public void testIfUserIsCreated()
	{
		p1 = Person.builder()
				   .id("1")
				   .name("John")
				   .age(19)
				   .build();
		
		personRepository.save(p1);
		
		//findById method is also called inside the service I want to test
		//so inside the read method of the service, by calling
		//findById method, an optional will be returned.
		//Check the implementation of service
		//if you want to see more.
		
		when(personRepository.findById("1")).thenReturn(Optional.of(p1));
		
		assertEquals(p1, personServiceUnderTest.read("1")); //read gets rid of optional by calling get	
	}
	
	@Test
	public void testIfAllUsersAreInsideTheDB()
	{
		reset(personRepository);
		
		Person p1 = Person.builder()
						  .id("1")
						  .name("Thanos")
						  .age(20)
						  .build();
		
		Person p2 = Person.builder()
						  .id("2")
						  .name("Eleni")
						  .age(20)
						  .build();
		
		personRepository.save(p1);
		personRepository.save(p2);
		
		when(personRepository.findAll()).thenReturn(List.of(p1, p2));
		
		assertEquals(List.of(p1, p2), personServiceUnderTest.readAll());	
	}
	
	@Test
	public void testIfUserIsDeleted()
	{
		reset(personRepository);
		
		Person p1 = Person.builder()
						  .id("1")
						  .name("Thanos")
						  .age(20)
						  .build();
		
		Person p2 = Person.builder()
						  .id("2")
						  .name("Eleni")
						  .age(20)
						  .build();
		
		personRepository.save(p1);
		personRepository.save(p2);
		personRepository.deleteById("1");
		
		when(personRepository.findAll()).thenReturn(List.of(p2));
		assertEquals(List.of(p2), personServiceUnderTest.readAll());
	}
	
	
}
