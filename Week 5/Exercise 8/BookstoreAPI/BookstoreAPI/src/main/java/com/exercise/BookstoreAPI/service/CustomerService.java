package com.exercise.BookstoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.BookstoreAPI.models.Customer;
import com.exercise.BookstoreAPI.repository.CustomerRepository;

import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;

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

    @Transactional
    public Customer updateCustomerById(Customer c, long id) {
        try {
            Customer customer = repo.findById(id).orElse(null);
            if (customer != null) {
                customer = c;
                repo.save(customer);
                return customer;
            } else {
                return null;
            }
        } catch (OptimisticLockException e) {
            throw new RuntimeException("Concurrency issue, please try again later!");
        }

    }

    @Transactional
    public Customer deleteCustomerById(long id) {
        try {
            Customer c = repo.findById(id).orElse(null);
            if (c != null) {
                repo.delete(c);
                return c;
            } else {
                return null;
            }
        } catch (OptimisticLockException e) {
            throw new RuntimeException("Concurrency issue, please try again later!");
        }
    }

}
