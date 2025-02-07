package com.thanos.secure_book_api_v1.repository;

import com.thanos.secure_book_api_v1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findBookByTitle(String title);
}
