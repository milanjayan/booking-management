package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.dtos.requests.CreateScreenRequest;
import com.scaler.bookingmanagement.exceptions.ScreenAlreadyPresentException;
import com.scaler.bookingmanagement.exceptions.ScreenNotFoundException;
import com.scaler.bookingmanagement.models.Screen;

import com.scaler.bookingmanagement.models.Theatre;
import com.scaler.bookingmanagement.repositories.ScreenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class ScreenService {

    private ScreenRepository screenRepository;
    private TheatreService theatreService;
    private CityService cityService;


    public Screen getScreen(Long id) {
        return screenRepository.findById(id)
                .orElseThrow(() -> new ScreenNotFoundException(
                        "Screen with id: "+id+" not found"
                ));
    }

    public Screen getScreen(Theatre theatre, String screeNumber) {
        return screenRepository.findScreenByTheatreAndNumber(theatre, screeNumber)
                .orElseThrow(() -> new ScreenNotFoundException(
                        "Screen: "+screeNumber+" in theatre: "+theatre.getName()+" not found"
                ));
    }
    public Screen createScreen(CreateScreenRequest request) {
        validate(request);
        Theatre theatre = theatreService.getTheatreByNameAndCityName(request.getTheatreName(), request.getCityName());
        Screen screen = Screen.builder()
                .theatre(theatre)
                .number(request.getScreenNumber())
                .build();
        return screenRepository.save(screen);
    }

    private void validate(CreateScreenRequest request) {
        //do all validations here
        Theatre theatre = theatreService.getTheatreByNameAndCityName(request.getTheatreName(), request.getCityName());
        Optional<Screen> screen = screenRepository.findScreenByTheatreAndNumber(theatre, request.getScreenNumber());
        if(screen.isPresent()) {
            throw new ScreenAlreadyPresentException(
                    "Screen with name: "+request.getScreenNumber()+
                            " already present in theatre "+theatre.getName()
            );
        }
    }
}
