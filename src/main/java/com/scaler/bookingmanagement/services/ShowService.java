package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.dtos.requests.CreateShowRequest;
import com.scaler.bookingmanagement.dtos.requests.GetShowsRequest;
import com.scaler.bookingmanagement.dtos.response.ShowResponse;
import com.scaler.bookingmanagement.enums.SeatStatus;
import com.scaler.bookingmanagement.exceptions.InvalidEndTimeException;
import com.scaler.bookingmanagement.exceptions.ShowNotFoundException;
import com.scaler.bookingmanagement.models.*;
import com.scaler.bookingmanagement.repositories.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ShowService {
    private ShowRepository showRepository;
    private MovieService movieService;
    private TheatreService theatreService;
    private ScreenService screenService;
    private ShowSeatService showSeatService;
    private SeatService seatService;
    public Show getShowById(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new ShowNotFoundException(
                        "Show with id: "+id+" not found"
                ));
    }

    public List<ShowResponse> getShows(GetShowsRequest request) {
        List<Show> shows = showRepository.findAllByTheatreCityNameAndTheatreNameAndMovieName(request.getCityName(), request.getTheatreName(), request.getMovieName());
        return shows.stream().map(
                show -> ShowResponse.builder()
                        .showId(show.getId())
                        .movieName(show.getMovie().getName())
                        .language(show.getLanguage())
                        .startTime(show.getStartTime())
                        .endTime(show.getEndTime())
                        .features(show.getFeatures())
                        .screenNumber(show.getScreen().getNumber())
                        .build()
        ).toList();
    }

    public Show createShow(CreateShowRequest request) {
        Theatre theatre = theatreService.getTheatreByNameAndCityName(request.getTheatreName(), request.getCityName());
        Screen screen = screenService.getScreen(theatre, request.getScreenNumber());
        Movie movie = movieService.getMovie(request.getMovieName());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(request.getStartTime(), formatter);
        LocalDateTime endTime = LocalDateTime.parse(request.getEndTime(), formatter);
        validateStartAndEndTime(startTime, endTime);

        Show show = Show.builder()
                .startTime(startTime)
                .endTime(endTime)
                .features(request.getFeatures())
                .movie(movie)
                .language(request.getLanguage())
                .screen(screen)
                .theatre(theatre)
                .build();
        showRepository.save(show);

        List<Seat> seats = seatService.getAllSeatByScreenId(screen.getId());
        List<ShowSeat> showSeats =  seats.stream().map(
                seat -> ShowSeat.builder()
                        .show(show)
                        .seat(seat)
                        .status(SeatStatus.AVAILABLE)
                        .build()
        ).toList();
        showSeatService.createShowSeats(showSeats);
        show.setShowSeats(showSeats);
        return show;
    }

    private void validateStartAndEndTime(LocalDateTime startTime, LocalDateTime endTime) {
        if(endTime.isBefore(startTime)) {
            throw new InvalidEndTimeException("Ending time should be after the starting time");
        }
    }


}
