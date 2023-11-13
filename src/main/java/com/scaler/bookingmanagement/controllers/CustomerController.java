package com.scaler.bookingmanagement.controllers;

import com.scaler.bookingmanagement.dtos.requests.CreateCustomerRequest;
import com.scaler.bookingmanagement.exceptions.InvalidCustomerCredentialsException;
import com.scaler.bookingmanagement.models.Customer;
import com.scaler.bookingmanagement.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerRequest request) {
        validate(request);
        return customerService.create(request);
    }

    private void validate(CreateCustomerRequest request) {
        if(request.getFullName() == null) {
            throw new InvalidCustomerCredentialsException("FullName cannot be null");
        }
        if(request.getEmail() == null) {
            throw new InvalidCustomerCredentialsException("Email cannot be null");
        }
        if(request.getPassword() == null) {
            throw new InvalidCustomerCredentialsException("Password cannot be null");
        }
    }
}
