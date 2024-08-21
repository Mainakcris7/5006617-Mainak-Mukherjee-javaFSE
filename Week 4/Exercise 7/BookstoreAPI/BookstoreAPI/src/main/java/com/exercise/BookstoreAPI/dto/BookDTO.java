package com.exercise.BookstoreAPI.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Component
@Data
public class BookDTO {

    // Custom JSON serialization and deserialization
    @JsonProperty("book_id")
    private long id;

    @JsonProperty("book_title")
    private String title;

    @JsonProperty("book_author")
    private String author;

    @JsonIgnore
    private double price;

    @JsonProperty("isbn_code")
    private String isbn;
}
