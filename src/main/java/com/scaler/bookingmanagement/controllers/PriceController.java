package com.scaler.bookingmanagement.controllers;

import com.scaler.bookingmanagement.dtos.requests.CreatePriceRequest;
import com.scaler.bookingmanagement.exceptions.InvalidPriceDetailsException;
import com.scaler.bookingmanagement.models.Price;
import com.scaler.bookingmanagement.services.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
@AllArgsConstructor
public class PriceController {
    private PriceService priceService;

    @GetMapping("{id}")
    public Price getPrice(@PathVariable Long id) {
        return priceService.getPriceById(id);
    }

    @PostMapping
    public Price createPrice(@RequestBody CreatePriceRequest request) {
        validate(request);
        return priceService.createPrice(request);
    }

    private void validate(CreatePriceRequest request) {
        if(request.getTheatreId() == null) {
            throw new InvalidPriceDetailsException("Theatre Id required");
        }
        if(request.getFeature() == null) {
            throw new InvalidPriceDetailsException("Feature required");
        }
        if(request.getSeatType() == null) {
            throw new InvalidPriceDetailsException("Seat type required");
        }
        if(request.getPrice() == null) {
            throw new InvalidPriceDetailsException("Price required");
        }
    }
}
