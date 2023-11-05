package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.TicketStatus;

import java.util.List;

public class Ticket {
    private int number;
    private User user;
    private Double amount;
    private List<Seat> seats;
    private Show show;
    private TicketStatus status;
}
