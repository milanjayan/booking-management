package com.scaler.bookingmanagement.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Customer with id: "+ id + " not found");
    }
}
