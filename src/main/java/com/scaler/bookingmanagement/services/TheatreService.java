package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.dtos.requests.CreateTheatreRequest;
import com.scaler.bookingmanagement.exceptions.TheatreAlreadyExistsException;
import com.scaler.bookingmanagement.exceptions.TheatreNotFoundException;
import com.scaler.bookingmanagement.models.City;
import com.scaler.bookingmanagement.models.Theatre;
import com.scaler.bookingmanagement.repositories.TheatreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TheatreService {

    private TheatreRepository theatreRepository;
    private CityService cityService;

    public Theatre getTheatre(Long id) {
        return theatreRepository.findById(id)
                .orElseThrow(() -> new TheatreNotFoundException("Theatre with id: "+id+" not found"));
    }

    public Theatre getTheatreByNameAndCityName(String theatreName, String cityName) {
        return theatreRepository.findTheatreByNameAndCityName(theatreName, cityName)
                .orElseThrow(() -> new TheatreNotFoundException(
                        "Theatre with name: "+theatreName+" in city "+cityName+" not found"
                ));
    }
    public Theatre getTheatre(String name) {
        return theatreRepository.findTheatreByName(name)
                .orElseThrow(() -> new TheatreNotFoundException("Theatre with name: "+name+" not found"));
    }

    public Theatre createTheatre(CreateTheatreRequest request) {
        validate(request);
        City city = cityService.getOrCreateCity(request.getCityName());
        Theatre theatre = Theatre.builder()
                .city(city)
                .name(request.getTheatreName())
                .address(request.getTheatreAddress())
                .build();
        return theatreRepository.save(theatre);
    }

    private void validate(CreateTheatreRequest request) {
        String theatreName = request.getTheatreName();
        String cityName = request.getCityName();
        String address = request.getTheatreAddress();
        theatreRepository.findTheatreByNameAndCityNameAndAddress(
                theatreName,
                cityName,
                address
        ).ifPresent(value -> {
            throw new TheatreAlreadyExistsException(
                    "Theatre with name: "+theatreName+" and address: "
                    +address+" already present in city "+cityName
            );
        });
    }


}
