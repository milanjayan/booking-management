package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.Genre;
import com.scaler.bookingmanagement.enums.Language;
import com.scaler.bookingmanagement.enums.MovieFeature;

import java.time.Duration;
import java.util.List;

public class Movie {
    private String name;
    private Duration duration;
    private Double rating;
    private List<Language> languages;
    private List<MovieFeature> features;
    private List<Genre> genres;
}
