package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.dtos.requests.CreatePriceRequest;
import com.scaler.bookingmanagement.enums.MovieFeature;
import com.scaler.bookingmanagement.enums.SeatType;
import com.scaler.bookingmanagement.exceptions.PriceNotFoundException;
import com.scaler.bookingmanagement.models.Price;
import com.scaler.bookingmanagement.models.Theatre;
import com.scaler.bookingmanagement.repositories.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PriceService {
    private PriceRepository priceRepository;
    private TheatreService theatreService;

    public Price getPriceById(Long id) {
        return priceRepository.findById(id)
                .orElseThrow(() -> new PriceNotFoundException("Price with id: "+id+" not found"));
    }

    public Price createPrice(CreatePriceRequest request) {
        Theatre theatre = theatreService.getTheatre(request.getTheatreId());
        Price price = Price.builder()
                .theatre(theatre)
                .feature(request.getFeature())
                .seatType(request.getSeatType())
                .price(request.getPrice())
                .build();
        return priceRepository.save(price);
    }

    public Double getPriceByTheatreAndSeatTypeAndFeatures(Theatre theatre, SeatType seatType, List<MovieFeature> features) {
        Optional<Price> price = priceRepository.findTopByTheatreAndSeatTypeAndFeatureInOrderByPriceDesc(theatre, seatType, features);
        if(price.isPresent()) {
            return price.get().getPrice();
        }
        throw new PriceNotFoundException("Price for seat type: "+seatType+" in theatre: "+theatre.getName()+" not found");
    }
}
