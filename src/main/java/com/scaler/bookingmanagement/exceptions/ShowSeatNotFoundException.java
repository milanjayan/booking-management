package com.scaler.bookingmanagement.exceptions;

public class ShowSeatNotFoundException extends RuntimeException {
    public ShowSeatNotFoundException(String message) {
        super(message);
    }
}
