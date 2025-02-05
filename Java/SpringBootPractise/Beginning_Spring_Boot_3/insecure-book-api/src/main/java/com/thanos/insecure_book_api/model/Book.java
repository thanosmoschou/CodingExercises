package com.thanos.insecure_book_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

// Do not use Lombok again...
@Entity
@Table(name = "books")
public class Book {
    @Id
    @NotNull
    @Column(name = "isbn")
    private String isbn;

    @NotNull
    @Column(name = "author")
    private String author;

    @NotNull
    @Column(name = "title")
    private String title;

    public Book() {
        this.isbn = "3545454";
        this.author = "test";
        this.title = "test";
    }

    public Book(String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "Isbn: " + isbn + " Title: " + title + " Author: " + author;
    }
}
