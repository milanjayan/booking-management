package com.scaler.bookingmanagement.exceptions;

public class InvalidBookingDetailsException extends RuntimeException {
    public InvalidBookingDetailsException(String message) {
        super(message);
    }
}
