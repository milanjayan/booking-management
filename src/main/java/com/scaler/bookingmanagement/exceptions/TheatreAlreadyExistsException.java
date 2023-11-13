package com.scaler.bookingmanagement.exceptions;

public class TheatreAlreadyExistsException extends RuntimeException {
    public TheatreAlreadyExistsException(String message) {
        super(message);
    }
}
