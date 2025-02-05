/*
Author: Thanos Moschou
Description: Insecure book rest api, project based on Beginning Spring Boot 3 book
Dependencies: Spring Web, Spring Data JPA, MySQL Driver, Lombok
You need to have MySQL configured on your pc.

This repository is a simple CRUD repository.
 */

package com.thanos.insecure_book_api.repositories;

import com.thanos.insecure_book_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// I annotated the repository with @Repository so I do not need to have a Config class
// where I create configuration beans
@Repository // This is an interface and repository. Annotate it with @Repository
public interface BookRepository extends JpaRepository<Book, String> {
    public Book findBookByTitle(String title); // Spring Data JPA creates automatically the query based on the method name
    public void deleteBookByTitle(String title);
}
