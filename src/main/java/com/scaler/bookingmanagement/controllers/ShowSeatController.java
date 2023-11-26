package com.scaler.bookingmanagement.controllers;

import com.scaler.bookingmanagement.models.ShowSeat;
import com.scaler.bookingmanagement.services.ShowSeatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showseat")
@AllArgsConstructor
public class ShowSeatController {
    private ShowSeatService showSeatService;

    @GetMapping("{id}")
    public ShowSeat getShowSeat(@PathVariable Long id) {
        return showSeatService.getShowSeat(id);
    }

    @GetMapping("/showseats")
    public List<ShowSeat> getShowSeats(@RequestParam Long showId) {
        return showSeatService.getShowSeats(showId);
    }
}
