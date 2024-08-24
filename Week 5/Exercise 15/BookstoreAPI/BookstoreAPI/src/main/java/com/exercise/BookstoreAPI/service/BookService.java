package com.exercise.BookstoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.BookstoreAPI.models.Book;
import com.exercise.BookstoreAPI.repository.BookRepository;

import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public List<Book> getBooks() {
        return repo.findAll();
    }

    public Book getBookById(long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Book> saveBooks(List<Book> bookList) {
        return repo.saveAll(bookList);
    }

    public Book saveBook(Book book) {
        return repo.save(book);
    }

    @Transactional
    public Book updateBook(Book book, long id) {
        try {
            Book b = repo.findById(id).orElse(null);
            b = book;
            return repo.save(b);
        } catch (OptimisticLockException e) {
            throw new RuntimeException("Concurrency issue, please try again later!");
        }
    }

    @Transactional
    public Book deleteBook(long id) {
        try {
            Book b = repo.findById(id).orElse(null);
            if (b != null) {
                repo.deleteById(id);
            }
            return b;
        } catch (OptimisticLockException e) {
            throw new RuntimeException("Concurrency issue, please try again later!");
        }
    }

    public List<Book> getBooksByAuthor(String author) {
        return repo.findByAuthor(author);
    }

    public List<Book> getBooksByTitle(String title) {
        return repo.findByTitle(title);
    }

}
