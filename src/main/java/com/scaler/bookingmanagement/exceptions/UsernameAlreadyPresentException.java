package com.scaler.bookingmanagement.exceptions;

public class UsernameAlreadyPresentException extends RuntimeException {
    public UsernameAlreadyPresentException(String username) {
        super("Username: "+username+" already present");
    }
}
