package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.Language;
import com.scaler.bookingmanagement.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "shows")
public class Show extends BaseModel {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @Enumerated
    private Language language;
    @ManyToOne
    private Screen screen;
}
