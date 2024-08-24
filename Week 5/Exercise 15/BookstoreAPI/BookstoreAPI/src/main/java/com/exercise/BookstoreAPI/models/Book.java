package com.exercise.BookstoreAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Title can't be empty")
    @Size(min = 3, max = 20)
    private String title;

    @NotEmpty(message = "Author can't be empty")
    private String author;

    @NotEmpty(message = "Price can't be empty")
    @Min(value = 0, message = "Price can't be negative")
    private double price;

    @NotEmpty(message = "isbn can't be empty")
    private String isbn;

    @Version
    private int version;
}
