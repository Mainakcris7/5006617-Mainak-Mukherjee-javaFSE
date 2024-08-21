package com.exercise.BookstoreAPI.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookException extends RuntimeException {
    private String errName;
    private String field;
    private String value;

    public BookException(String errName, String field, String value) {
        super(String.format("%s: Invalid value: %s for the field: %s", errName, value, field));
        this.errName = errName;
        this.field = field;
        this.value = value;
    }

}
