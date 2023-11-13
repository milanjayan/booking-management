package com.scaler.bookingmanagement.exceptions;

public class SeatAlreadyPresentException extends RuntimeException {
    public SeatAlreadyPresentException(String row, String column) {
        super("Seat at row: "+row+" column: "+column+" already present");
    }
}
