package com.scaler.bookingmanagement.exceptions;

public class InvalidPriceDetailsException extends RuntimeException {
    public InvalidPriceDetailsException(String message) {
        super(message);
    }
}
