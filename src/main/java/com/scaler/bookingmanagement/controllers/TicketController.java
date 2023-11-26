package com.scaler.bookingmanagement.controllers;

import com.scaler.bookingmanagement.dtos.requests.CreateTicketRequest;
import com.scaler.bookingmanagement.exceptions.InvalidBookingDetailsException;
import com.scaler.bookingmanagement.models.Ticket;
import com.scaler.bookingmanagement.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class TicketController {
    private TicketService ticketService;

    @GetMapping("{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketService.getTicket(id);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody CreateTicketRequest request) {
        validate(request);
        return ticketService.createTicket(request);
    }

    private void validate(CreateTicketRequest request) {
        if(request.getShowId() == null) {
            throw new InvalidBookingDetailsException("Show id cannot be null");
        }
        if(request.getCustomerId() == null) {
            throw new InvalidBookingDetailsException("Customer id cannot be null");
        }
        if(request.getShowSeatIds().isEmpty()) {
            throw new InvalidBookingDetailsException("Show seats cannot be empty");
        }
    }
}
