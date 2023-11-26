package com.scaler.bookingmanagement.controllers;

import com.scaler.bookingmanagement.dtos.requests.CreateMovieRequest;
import com.scaler.bookingmanagement.exceptions.InvalidMovieDetailsException;
import com.scaler.bookingmanagement.models.Movie;
import com.scaler.bookingmanagement.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody CreateMovieRequest request) {
        validate(request);
        Movie movie = request.transform();
        return movieService.createMovie(movie);
    }

    private void validate(CreateMovieRequest request) {
        if(request.getName() == null) {
            throw new InvalidMovieDetailsException("Movie name required");
        }
        if(request.getDuration() == null) {
            throw new InvalidMovieDetailsException("Movie duration required");
        }
        if(request.getLanguages().isEmpty()) {
            throw new InvalidMovieDetailsException("Movie languages required");
        }
    }
}
