package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void showRepository(){
        System.out.println("Book repository...");
    }
}
