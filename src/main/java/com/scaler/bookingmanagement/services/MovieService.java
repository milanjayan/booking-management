package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.dtos.requests.CreateMovieRequest;
import com.scaler.bookingmanagement.exceptions.MovieAlreadyPresentException;
import com.scaler.bookingmanagement.exceptions.MovieNotFoundException;
import com.scaler.bookingmanagement.models.Movie;
import com.scaler.bookingmanagement.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;
    public Movie getMovie(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(()-> new MovieNotFoundException("Movie with id: "+id+" not found"));
    }

    public Movie getMovie(String name) {
        return movieRepository.findMovieByName(name)
                .orElseThrow(()-> new MovieNotFoundException("Movie with name: "+name+" not found"));
    }
    public Movie createMovie(Movie movie) {
        validate(movie);
        return movieRepository.save(movie);
    }

    private void validate(Movie movie) {
        //validations
        String name = movie.getName();
        movieRepository.findMovieByName(name)
                .ifPresent(value -> {
                    throw new MovieAlreadyPresentException(name);
                });
    }
}
