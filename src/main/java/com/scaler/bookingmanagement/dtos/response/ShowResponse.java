package com.scaler.bookingmanagement.dtos.response;

import com.scaler.bookingmanagement.enums.Language;
import com.scaler.bookingmanagement.enums.MovieFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowResponse {
    private Long showId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String movieName;
    private Language language;
    private List<MovieFeature> features;
    private String screenNumber;
}
