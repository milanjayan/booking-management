package com.scaler.bookingmanagement.exceptions;

public class MovieAlreadyPresentException extends RuntimeException {
    public MovieAlreadyPresentException(String name) {
        super("Movie with name: "+name+" already present");
    }
}
