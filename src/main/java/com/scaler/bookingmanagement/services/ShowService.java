package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.dtos.requests.CreateShowRequest;
import com.scaler.bookingmanagement.exceptions.InvalidEndTimeException;
import com.scaler.bookingmanagement.exceptions.ShowNotFoundException;
import com.scaler.bookingmanagement.models.*;
import com.scaler.bookingmanagement.repositories.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class ShowService {
    private ShowRepository showRepository;
    private MovieService movieService;
    private TheatreService theatreService;
    private ScreenService screenService;
    public Show getShowById(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new ShowNotFoundException(
                        "Show with id: "+id+" not found"
                ));
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
                .build();
        return showRepository.save(show);
    }

    private void validateStartAndEndTime(LocalDateTime startTime, LocalDateTime endTime) {
        if(endTime.isBefore(startTime)) {
            throw new InvalidEndTimeException("Ending time should be after the starting time");
        }
    }
}
