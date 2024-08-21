package com.exercise.BookstoreAPI.dto;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CustomerDTO {
    private long id;
    private String name;
    private String email;
    private String password;
}
