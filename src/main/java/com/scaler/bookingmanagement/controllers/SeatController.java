package com.scaler.bookingmanagement.controllers;

import com.scaler.bookingmanagement.dtos.requests.CreateSeatRequest;
import com.scaler.bookingmanagement.exceptions.InvalidSeatDetailsException;
import com.scaler.bookingmanagement.models.Seat;
import com.scaler.bookingmanagement.services.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seat")
@AllArgsConstructor
public class SeatController {
    private SeatService seatService;

    @PostMapping
    public Seat createSeat(@RequestBody CreateSeatRequest request) {
        validate(request);
        return seatService.createSeat(request);
    }

    private void validate(CreateSeatRequest request) {
        if(request.getCityName() == null) {
            throw new InvalidSeatDetailsException("City name required");
        }
        if(request.getTheatreName() == null) {
            throw new InvalidSeatDetailsException("Theatre name required");
        }
        if(request.getScreenNumber() == null) {
            throw new InvalidSeatDetailsException("Screen number required");
        }
        if(request.getRow() == null) {
            throw new InvalidSeatDetailsException("Seat row required");
        }
        if(request.getColumn() == null) {
            throw new InvalidSeatDetailsException("Seat Column required");
        }
    }
}
