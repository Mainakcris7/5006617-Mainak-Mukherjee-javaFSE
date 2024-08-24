package com.exercise.BookstoreAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Invalid Email ID")
    private String email;

    @NotEmpty
    @Pattern(regexp = "[a-zA-Z\\S]{8,20}", message = "Invalid password")
    private String password;

    @Version
    private int version;
}
