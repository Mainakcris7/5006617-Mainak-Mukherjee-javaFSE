package com.exercise.BookstoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.BookstoreAPI.models.Customer;
import com.exercise.BookstoreAPI.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;

    public List<Customer> getCustomers() {
        return repo.findAll();
    }

    public Customer getCustomerById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Customer saveCustomer(Customer c) {
        return repo.save(c);
    }

    public List<Customer> saveCustomers(List<Customer> customerList) {
        return repo.saveAll(customerList);
    }
}
