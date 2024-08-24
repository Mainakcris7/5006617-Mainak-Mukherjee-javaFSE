package com.exercise.BookstoreAPI.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.exercise.BookstoreAPI.dto.BookDTO;
import com.exercise.BookstoreAPI.models.Book;
import com.exercise.BookstoreAPI.service.BookService;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class BookController {
    @Autowired
    private BookService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/")
    public String index() {
        return "Welcome to BookAPI project";
    }

    // Navigate to getBookByID and deleteByID using HATEOAS API
    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Book> list = service.getBooks();
        List<BookDTO> listDTO = list.stream().map(b -> mapper.map(b, BookDTO.class)).collect(Collectors.toList());
        if (list.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else {
            for (BookDTO b : listDTO) {
                b.add(linkTo(methodOn(BookController.class).getBookById(b.getId())).withRel("get-book"));
            }
            return ResponseEntity.ok(listDTO);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Book b = service.getBookById(id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(b);
        }
    }

    @PostMapping("/books/save-all")
    public ResponseEntity<List<Book>> saveBooks(@RequestBody List<Book> bookList) {
        List<Book> list = service.saveBooks(bookList);
        if (list.isEmpty())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        else
            return ResponseEntity.ok(list);
    }

    @PostMapping("/books/save-one")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book b = service.saveBook(book);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } else {
            return ResponseEntity.ok(b);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable long id) {
        Book b = service.updateBook(book, id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } else {
            return ResponseEntity.ok(b);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        Book b = service.deleteBook(id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } else {
            return ResponseEntity.ok(b);
        }
    }

}
