package com.scaler.bookingmanagement.exceptions;

public class InvalidSeatDetailsException extends RuntimeException {
    public InvalidSeatDetailsException(String message) {
        super(message);
    }
}
