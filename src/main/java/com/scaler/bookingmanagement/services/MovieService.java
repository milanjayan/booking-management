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

    public Movie createMovie(CreateMovieRequest request) {
        validate(request);
        Movie movie = Movie.builder()
                .name(request.getName())
                .duration(request.getDuration())
                .rating(request.getRating())
                .languages(request.getLanguages())
                .genres(request.getGenres())
                .shows(request.getShows())
                .features(request.getFeatures())
                .build();

        return movieRepository.save(movie);
    }

    private void validate(CreateMovieRequest request) {
        //validations
        String name = request.getName();
        movieRepository.findMovieByName(name)
                .ifPresent(value -> {
                    throw new MovieAlreadyPresentException(name);
                });
    }
}
