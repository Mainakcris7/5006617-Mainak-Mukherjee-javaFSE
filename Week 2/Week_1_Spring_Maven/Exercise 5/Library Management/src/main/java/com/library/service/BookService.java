package com.library.service;


import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class BookService {

    BookRepository repository;
    BookService(BookRepository repository) {
        this.repository = repository;
    }
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void runService(){
        repository.showRepository();
        System.out.println("Service is running...");
    }
}
