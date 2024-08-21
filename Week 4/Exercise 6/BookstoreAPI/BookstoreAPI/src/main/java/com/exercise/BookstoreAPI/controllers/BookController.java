package com.exercise.BookstoreAPI.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.exercise.BookstoreAPI.exceptions.BookException;
import com.exercise.BookstoreAPI.models.Book;
import com.exercise.BookstoreAPI.service.BookService;

import jakarta.websocket.server.PathParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public String index() {
        return "Welcome to BookAPI project";
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(@PathParam("title") String title,
            @PathParam("author") String author) {
        List<Book> list;
        if (author != null) {
            list = service.getBooksByAuthor(author);
            if (list.isEmpty()) {
                throw new BookException("BookAuthorNotFound", "author", author);
            } else
                return ResponseEntity.ok(list);
        } else if (title != null) {
            list = service.getBooksByTitle(title);
            if (list.isEmpty())
                throw new BookException("BookTitleNotFound", "title", title);
            else
                return ResponseEntity.ok(list);
        }
        list = service.getBooks();
        if (list.isEmpty())
            throw new BookException("BooksNotFound", "API", "/books");
        else
            return ResponseEntity.ok(list);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Book b = service.getBookById(id);
        return ResponseEntity.ok(b);
    }

    @PostMapping("/books/save-all")
    public ResponseEntity<List<Book>> saveBooks(@RequestBody List<Book> bookList) {
        List<Book> list = service.saveBooks(bookList);
        if (list.isEmpty())
            throw new BookException("BooksSaveError", "save", "null");
        else
            return ResponseEntity.ok(list);
    }

    @PostMapping("/books/save-one")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book b = service.saveBook(book);
        if (b == null) {
            throw new BookException("BookSaveError", "save", "null");
        } else {
            return ResponseEntity.ok(b);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable long id) {
        Book b = service.updateBook(book, id);
        return ResponseEntity.ok(b);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        Book b = service.deleteBook(id);
        return ResponseEntity.ok(b);
    }

}
