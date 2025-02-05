USE books_db;

DROP TABLE IF EXISTS books;

CREATE TABLE books (
    isbn VARCHAR(20) PRIMARY KEY,
    author VARCHAR(20),
    title VARCHAR(20)
);