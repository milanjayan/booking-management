package com.scaler.bookingmanagement.controllers;

import com.scaler.bookingmanagement.dtos.requests.CreateTheatreRequest;
import com.scaler.bookingmanagement.exceptions.InvalidTheatreDetailsException;
import com.scaler.bookingmanagement.models.Theatre;
import com.scaler.bookingmanagement.services.TheatreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatre")
@AllArgsConstructor
public class TheatreController {

    private TheatreService theatreService;

    @GetMapping("{id}")
    public Theatre getTheatre(@PathVariable Long id) {
        return theatreService.getTheatre(id);
    }

    @PostMapping
    public Theatre createTheatre(@RequestBody CreateTheatreRequest request) {
        validate(request);
        return theatreService.createTheatre(request);
    }

    private void validate(CreateTheatreRequest request) {
        if(request.getCityName() == null) {
            throw new InvalidTheatreDetailsException("City required");
        }
        if(request.getTheatreName() == null) {
            throw new InvalidTheatreDetailsException("Theatre name required");
        }
        if(request.getTheatreAddress() == null) {
            throw new InvalidTheatreDetailsException("Theatre address required");
        }
    }
}
