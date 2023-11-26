package com.scaler.bookingmanagement.exceptions;

public class InvalidSeatTypeException extends RuntimeException {
    public InvalidSeatTypeException(String message) {
        super(message);
    }
}
