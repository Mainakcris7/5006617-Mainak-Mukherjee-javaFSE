package com.exercise.BookstoreAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.BookstoreAPI.models.Customer;
import com.exercise.BookstoreAPI.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("")
    private ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> list = service.getCustomers();

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }

    @GetMapping("{id}")
    private ResponseEntity<Customer> getCustomer(@PathVariable long id) {
        Customer c = service.getCustomerById(id);

        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(c);
        }
    }

    // Save
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    private Customer saveCustomerJson(@Valid @RequestBody Customer c) {
        return service.saveCustomer(c);
    }

    // Update
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer c, @PathVariable long id) {
        Customer customer = service.updateCustomerById(c, id);
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(customer);
        }
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable long id) {
        Customer customer = service.deleteCustomerById(id);
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(customer);
        }
    }

}
