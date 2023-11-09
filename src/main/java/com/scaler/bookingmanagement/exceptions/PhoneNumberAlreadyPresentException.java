package com.scaler.bookingmanagement.exceptions;

public class PhoneNumberAlreadyPresentException extends RuntimeException {
    public PhoneNumberAlreadyPresentException(String phone) {
        super("Phone number: "+phone+" already present");
    }
}
