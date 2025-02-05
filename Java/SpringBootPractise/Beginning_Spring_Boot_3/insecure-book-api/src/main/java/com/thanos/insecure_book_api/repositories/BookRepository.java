package com.thanos.insecure_book_api.repositories;

import com.thanos.insecure_book_api.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// I annotated the repository with @Repository, so I do not need to have a Config class
// where I create configuration beans
// This repository is a simple CRUD repository.
@Repository // This is an interface and repository. Annotate it with @Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Book findBookByTitle(String title); // Spring Data JPA creates automatically the query based on the method name
    @Transactional
    void deleteBookByTitle(String title);
}
