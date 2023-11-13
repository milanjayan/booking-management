package com.scaler.bookingmanagement.controllers;

import com.scaler.bookingmanagement.dtos.requests.CreateScreenRequest;
import com.scaler.bookingmanagement.exceptions.InvalidScreenDetailsException;
import com.scaler.bookingmanagement.models.Screen;
import com.scaler.bookingmanagement.services.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/screen")
@AllArgsConstructor
public class ScreenController {
    private ScreenService screenService;

    @PostMapping
    public Screen createScreen(@RequestBody CreateScreenRequest request) {
        validate(request);
        return screenService.createScreen(request);
    }

    private void validate(CreateScreenRequest request) {
        if(request.getCityName() == null) {
            throw new InvalidScreenDetailsException("City name required");
        }
        if(request.getTheatreName() == null) {
            throw new InvalidScreenDetailsException("Theatre name required");
        }
        if(request.getScreenNumber() == null) {
            throw new InvalidScreenDetailsException("Screen name/number required");
        }
    }
}
