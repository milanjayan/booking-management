package com.scaler.bookingmanagement.exceptions;

public class ShowSeatAlreadyPresentException extends RuntimeException{
    public ShowSeatAlreadyPresentException(String message) {
        super(message);
    }
}
