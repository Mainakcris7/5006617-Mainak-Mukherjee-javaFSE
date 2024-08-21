package com.exercise.BookstoreAPI.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.BookstoreAPI.dto.BookDTO;
import com.exercise.BookstoreAPI.models.Book;
import com.exercise.BookstoreAPI.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    @Autowired
    private ModelMapper mapper;

    // Return BookDTO
    public BookDTO getBookById(long id) {
        Book b = repo.findById(id).orElse(null);
        if (b != null) {
            return mapper.map(b, BookDTO.class);
        }
        return null;
    }

    public BookDTO saveBook(Book book) {
        return mapper.map(repo.save(book), BookDTO.class);
    }

    public BookDTO updateBook(Book book, long id) {
        Book b = repo.findById(id).orElse(null);
        b = book;
        if (b != null) {
            return mapper.map(b, BookDTO.class);
        }
        return null;
    }

    public BookDTO deleteBook(long id) {
        Book b = repo.findById(id).orElse(null);
        if (b != null) {
            repo.deleteById(id);
            return mapper.map(b, BookDTO.class);
        } else {
            return null;
        }
    }

}
