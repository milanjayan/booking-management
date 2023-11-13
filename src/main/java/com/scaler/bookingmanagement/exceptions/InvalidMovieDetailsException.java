package com.scaler.bookingmanagement.exceptions;

public class InvalidMovieDetailsException extends RuntimeException {
    public InvalidMovieDetailsException(String message) {
        super(message);
    }
}
