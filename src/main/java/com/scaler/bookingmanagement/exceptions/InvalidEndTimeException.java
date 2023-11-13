package com.scaler.bookingmanagement.exceptions;

public class InvalidEndTimeException extends RuntimeException {
    public InvalidEndTimeException(String message) {
        super(message);
    }
}
