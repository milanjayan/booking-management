package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.dtos.requests.CreateSeatRequest;
import com.scaler.bookingmanagement.exceptions.SeatAlreadyPresentException;
import com.scaler.bookingmanagement.models.Screen;
import com.scaler.bookingmanagement.models.Seat;
import com.scaler.bookingmanagement.models.Theatre;
import com.scaler.bookingmanagement.repositories.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeatService {

    private SeatRepository seatRepository;
    private ScreenService screenService;
    private TheatreService theatreService;
    public Seat createSeat(CreateSeatRequest request) {
        Theatre theatre = theatreService.getTheatreByNameAndCityName(request.getTheatreName(), request.getCityName());
        Screen screen = screenService.getScreen(theatre, request.getScreenNumber());
        validate(request, screen);

        Seat seat = Seat.builder()
                .screen(screen)
                .row(request.getRow())
                .column(request.getColumn())
                .type(request.getSeatType())
                .build();
        return seatRepository.save(seat);
    }

//    public List<Seat> createSeats(int rows, int columns, Screen screen) {
//        return null;
//    }

    private void validate(CreateSeatRequest request, Screen screen) {
        seatRepository.findSeatByScreenAndRowAndColumn(screen, request.getRow(), request.getColumn())
                .ifPresent(value -> {
                    throw new SeatAlreadyPresentException(request.getRow(), request.getColumn());
                });
    }
}
