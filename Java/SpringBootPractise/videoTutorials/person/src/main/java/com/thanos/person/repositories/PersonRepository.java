/*
 * Author: Thanos Moschou
 * Description: This is a simple rest api. This is based on devtiro's rest api tutorial
 * but I make a people api instead of books.
 */

package com.thanos.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thanos.person.domain.Person;

/*
 * Spring Data JPA focuses on using JPA to store data in a relational database. 
 * Its most compelling feature is the ability to create repository implementations automatically, 
 * at runtime, from a repository interface.
 * 
 * Repository is the abstraction we use to save and retrieve things from our database
 * JpaRepository interface gets the entity class type and the type of the id.
 * 
 * Also I need the @Repository annotation. It tells spring that this is a repository.
 * It is the thing we can use to interact with the persistence layer. It also adds the
 * repository to the application context in order to get injected where needed.
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, String>
{

}
