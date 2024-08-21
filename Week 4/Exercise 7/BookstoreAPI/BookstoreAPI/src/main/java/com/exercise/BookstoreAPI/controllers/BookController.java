package com.exercise.BookstoreAPI.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.exercise.BookstoreAPI.dto.BookDTO;
import com.exercise.BookstoreAPI.models.Book;
import com.exercise.BookstoreAPI.service.BookService;
import jakarta.websocket.server.PathParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public String index() {
        return "Welcome to BookAPI project";
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable long id) {
        System.out.println(id);
        BookDTO b = service.getBookById(id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(b);
        }
    }

    @PostMapping("/books/save-one")
    public ResponseEntity<BookDTO> saveBook(@RequestBody Book book) {
        BookDTO b = service.saveBook(book);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } else {
            return ResponseEntity.ok(b);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookDTO> updateBook(@RequestBody Book book, @PathVariable long id) {
        BookDTO b = service.updateBook(book, id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } else {
            return ResponseEntity.ok(b);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable long id) {
        BookDTO b = service.deleteBook(id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } else {
            return ResponseEntity.ok(b);
        }
    }

}
