package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.exceptions.ShowSeatAlreadyPresentException;
import com.scaler.bookingmanagement.exceptions.ShowSeatNotFoundException;
import com.scaler.bookingmanagement.models.ShowSeat;
import com.scaler.bookingmanagement.repositories.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatService {

    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeat(Long id) {
        return showSeatRepository.findById(id)
                .orElseThrow(()-> new ShowSeatNotFoundException("Show seat with id: "+id+" not found"));
    }

    public List<ShowSeat> getShowSeats(Long showId) {
        return showSeatRepository.findAllByShow_Id(showId);
    }

    public List<ShowSeat> createShowSeats(List<ShowSeat> showSeats) {
        for(ShowSeat showSeat : showSeats) {
            validate(showSeat);
        }
        return showSeatRepository.saveAll(showSeats);
    }

    private void validate(ShowSeat showSeat) {
        showSeatRepository.findShowSeatByShowAndSeat(showSeat.getShow(), showSeat.getSeat())
                .ifPresent(value -> {
                    throw new ShowSeatAlreadyPresentException("Seat already present for show");
                });
    }

    public List<ShowSeat> saveAll(List<ShowSeat> lockedSeats) {
//        System.out.println("<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
//        for(ShowSeat seat: lockedSeats) {
//            System.out.println(seat.getShow().getMovie().getName());
//            System.out.println(seat.getId());
//            System.out.println(seat.getSeat().getType());
//            System.out.println(seat.getStatus());
//        }
//        System.out.println("<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
        return showSeatRepository.saveAll(lockedSeats);
    }
}
