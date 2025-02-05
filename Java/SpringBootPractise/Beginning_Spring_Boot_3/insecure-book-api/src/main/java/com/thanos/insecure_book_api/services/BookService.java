package com.thanos.insecure_book_api.services;

import com.thanos.insecure_book_api.model.Book;
import com.thanos.insecure_book_api.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// I have annotated the class with @Service and this means that I do not have
// to create a Config class where I create configuration beans
@Service // This class is a service class. Annotate it with @Service
public class BookService {
    @Autowired // Dependency Injection
    private BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    public Book findBookByISBN(String isbn) {
        return bookRepository.findById(isbn).isPresent() ? bookRepository.findById(isbn).get() : null;
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookByTitle(String title) {
        bookRepository.deleteBookByTitle(title);
    }
}
