package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.Language;
import com.scaler.bookingmanagement.enums.MovieFeature;

import java.time.LocalDateTime;
import java.util.List;

public class Show {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<MovieFeature> features;
    private Movie movie;
    private Language language;
    private Long theatreId;
    private Screen  screen;
}
