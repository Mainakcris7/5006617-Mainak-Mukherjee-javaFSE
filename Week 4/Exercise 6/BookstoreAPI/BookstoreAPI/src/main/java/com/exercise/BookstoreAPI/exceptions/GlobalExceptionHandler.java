package com.exercise.BookstoreAPI.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookException.class)
    public ResponseEntity<Map<String, String>> throwBookException(BookException ex) {
        Map<String, String> errMap = new HashMap<>();
        errMap.put("message", ex.getMessage());
        errMap.put("field", ex.getField());
        errMap.put("value", ex.getValue());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errMap);
    }
}
