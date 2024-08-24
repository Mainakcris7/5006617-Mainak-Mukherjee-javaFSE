package com.exercise.BookstoreAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.BookstoreAPI.models.Customer;
import com.exercise.BookstoreAPI.service.CustomerService;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Go to http://localhost:8080/admin/metrics/customers_hit_count to see how many times "/customers" is hit 
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @Autowired
    private MeterRegistry meterRegistry;

    @GetMapping("")
    private ResponseEntity<List<Customer>> getAllCustomers() {
        Counter counter = Counter.builder("customers_hit_count")
                .description("Shows the no. of times the /customers is hit")
                .tag("endpoint", "/customers")
                .register(meterRegistry);

        counter.increment();

        List<Customer> list = service.getCustomers();

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }

    // Accept form data
    @PostMapping("/save/form")
    @ResponseStatus(code = HttpStatus.CREATED)
    private Customer saveCustomerForm(@ModelAttribute Customer c) {
        return service.saveCustomer(c);
    }

    // Accept JSON data
    @PostMapping("/save/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    private Customer saveCustomerJson(@RequestBody Customer c) {
        return service.saveCustomer(c);
    }

}
