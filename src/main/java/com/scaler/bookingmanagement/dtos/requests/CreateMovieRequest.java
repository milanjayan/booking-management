package com.scaler.bookingmanagement.dtos.requests;

import com.scaler.bookingmanagement.enums.Genre;
import com.scaler.bookingmanagement.enums.Language;
import com.scaler.bookingmanagement.enums.MovieFeature;
import com.scaler.bookingmanagement.models.Show;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CreateMovieRequest {
    private String name;
    private String duration;
    private Double rating;
    private List<Language> languages;
    private List<MovieFeature> features;
    private List<Genre> genres;
    private List<Show> shows;
}
