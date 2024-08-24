package com.exercise.BookstoreAPI.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
public class BookDTO extends RepresentationModel<CustomerDTO> {
    private long id;
    private String title;
    private String author;
    private double price;
    private String isbn;
}
