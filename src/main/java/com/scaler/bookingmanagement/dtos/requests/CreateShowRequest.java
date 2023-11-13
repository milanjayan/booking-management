package com.scaler.bookingmanagement.dtos.requests;

import com.scaler.bookingmanagement.enums.Language;
import com.scaler.bookingmanagement.enums.MovieFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreateShowRequest {
    private String startTime;
    private String endTime;
    private List<MovieFeature> features;
    private String movieName;
    private Language language;
    private String cityName;
    private String theatreName;
    private String screenNumber;
}
