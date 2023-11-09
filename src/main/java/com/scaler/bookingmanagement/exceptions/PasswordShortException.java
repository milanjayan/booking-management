package com.scaler.bookingmanagement.exceptions;

public class PasswordShortException extends RuntimeException {
    public PasswordShortException(){
        super("Password should be at least 8 characters in length");
    }
}
