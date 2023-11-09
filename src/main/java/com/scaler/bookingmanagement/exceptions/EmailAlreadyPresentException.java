package com.scaler.bookingmanagement.exceptions;

public class EmailAlreadyPresentException extends RuntimeException {
    public EmailAlreadyPresentException(String email) {
        super("Email : "+email+" already present");
    }
}
