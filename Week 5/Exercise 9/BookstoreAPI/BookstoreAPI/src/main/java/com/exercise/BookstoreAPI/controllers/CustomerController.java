package com.exercise.BookstoreAPI.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.BookstoreAPI.dto.CustomerDTO;
import com.exercise.BookstoreAPI.models.Customer;
import com.exercise.BookstoreAPI.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("")
    private ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<Customer> list = service.getCustomers();
        List<CustomerDTO> listDTO = list.stream().map(c -> mapper.map(c, CustomerDTO.class))
                .collect(Collectors.toList());

        if (list.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else {
            for (CustomerDTO c : listDTO) {
                c.add(linkTo(methodOn(CustomerController.class).getCustomerById(c.getId())).withRel("get-customer"));
            }
            return ResponseEntity.ok(listDTO);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable long id) {
        Customer c = service.getCustomerById(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(mapper.map(c, CustomerDTO.class));
        }
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<CustomerDTO>> saveBooks(@RequestBody List<Customer> cList) {
        List<CustomerDTO> list = service.saveCustomers(cList).stream().map(c -> mapper.map(c, CustomerDTO.class))
                .collect(Collectors.toList());
        if (list.isEmpty())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        else
            return ResponseEntity.ok(list);
    }

}
