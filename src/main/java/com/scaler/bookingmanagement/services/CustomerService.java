package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.dtos.CreateCustomerRequest;
import com.scaler.bookingmanagement.exceptions.CustomerNotFoundException;
import com.scaler.bookingmanagement.exceptions.EmailAlreadyPresentException;
import com.scaler.bookingmanagement.exceptions.PhoneNumberAlreadyPresentException;
import com.scaler.bookingmanagement.exceptions.UsernameAlreadyPresentException;
import com.scaler.bookingmanagement.models.Customer;
import com.scaler.bookingmanagement.models.User;
import com.scaler.bookingmanagement.repositories.CustomerRepository;
import com.scaler.bookingmanagement.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    private UserService userService;
    public Customer create(CreateCustomerRequest request) {
        //validate customer email
        //validate customer phonenumber
        validate(request);

        return null;
    }

    private void validate(CreateCustomerRequest request) {
        String email = request.getEmail();
        Optional<Customer> existingCustomer = customerRepository.findCustomerByEmail(email);
        if(existingCustomer.isPresent()) {
            throw new EmailAlreadyPresentException(email);
        }
        String phone = request.getPhone();
        existingCustomer = customerRepository.findCustomerByPhone(phone);
        if(existingCustomer.isPresent()) {
            throw new PhoneNumberAlreadyPresentException(phone);
        }
    }

    public Customer getById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(()-> new CustomerNotFoundException(id));
    }
}
