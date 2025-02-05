package com.thanos.insecure_book_api.controllers;

import com.thanos.insecure_book_api.model.Book;
import com.thanos.insecure_book_api.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@Valid @RequestBody Book book) { // @Valid triggers the validation api
        /*
            If you send something like this
            {
                "isbn": "agg",
                "author": null,
                "title": "Spring"
            }
            you will get an error
        */
        bookService.addBook(book);
    }

    @GetMapping // Get mapping in /books
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/isbn/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public Book findBookByISBN(@PathVariable String isbn) {
        return bookService.findBookByISBN(isbn);
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Book findBookByTitle(@PathVariable String title) {
        return bookService.findBookByTitle(title);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@Valid @RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookByTitle(@PathVariable String title) {
        bookService.deleteBookByTitle(title);
    }
}
