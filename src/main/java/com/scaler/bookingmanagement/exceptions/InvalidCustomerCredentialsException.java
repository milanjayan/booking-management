package com.scaler.bookingmanagement.exceptions;

public class InvalidCustomerCredentialsException extends RuntimeException {
    public InvalidCustomerCredentialsException(String message) {
        super(message);
    }
}
