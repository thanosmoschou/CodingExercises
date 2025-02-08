package com.thanos.secure_book_api_v1.controllers;

import com.thanos.secure_book_api_v1.model.Book;
import com.thanos.secure_book_api_v1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Later on I will implement more crud operations

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added successfully";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAll() {
        return bookService.findAll();
    }
}
