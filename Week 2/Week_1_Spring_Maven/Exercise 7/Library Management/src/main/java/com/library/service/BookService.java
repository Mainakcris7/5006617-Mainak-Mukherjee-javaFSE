package com.library.service;


import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BookService {
    @Autowired
    BookRepository repository;

    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void runService(){
        repository.showRepository();
        System.out.println("Service is running...");
    }
}
