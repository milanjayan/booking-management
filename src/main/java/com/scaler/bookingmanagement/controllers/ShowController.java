package com.scaler.bookingmanagement.controllers;

import com.scaler.bookingmanagement.dtos.requests.CreateShowRequest;
import com.scaler.bookingmanagement.exceptions.InvalidShowDetailsException;
import com.scaler.bookingmanagement.models.Show;
import com.scaler.bookingmanagement.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
@AllArgsConstructor
public class ShowController {
    private ShowService showService;

    @GetMapping("{id}")
    public Show getShow(@PathVariable Long id) {
        return showService.getShowById(id);
    }

    @PostMapping
    public Show createShow(@RequestBody CreateShowRequest request) {
        validate(request);
        return showService.createShow(request);
    }

    private void validate(CreateShowRequest request) {
        if(request.getStartTime() == null) {
            throw new InvalidShowDetailsException("Start time required");
        }
        if(request.getEndTime() == null) {
            throw new InvalidShowDetailsException("End time required");
        }
        if(request.getMovieName() == null) {
            throw new InvalidShowDetailsException("Movie name required");
        }
        if(request.getLanguage() == null) {
            throw new InvalidShowDetailsException("Movie language required");
        }
        if(request.getCityName() == null) {
            throw new InvalidShowDetailsException("Theatre city required");
        }
        if(request.getTheatreName() == null) {
            throw new InvalidShowDetailsException("Theatre name required");
        }
        if(request.getScreenNumber() == null) {
            throw new InvalidShowDetailsException("Screen number required");
        }
    }
}
