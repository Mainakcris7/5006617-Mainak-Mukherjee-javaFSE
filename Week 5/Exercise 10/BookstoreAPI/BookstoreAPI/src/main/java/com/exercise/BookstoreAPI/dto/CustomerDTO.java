package com.exercise.BookstoreAPI.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
public class CustomerDTO extends RepresentationModel<CustomerDTO> {
    private long id;
    private String name;
    private String email;
    private String password;
}
