package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.Genre;
import com.scaler.bookingmanagement.enums.Language;
import com.scaler.bookingmanagement.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie extends BaseModel {
    private String name;
    private Duration duration;
    private Double rating;
    @ElementCollection
    @Enumerated
    private List<Language> languages = new ArrayList<>();
    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();
    @ElementCollection
    @Enumerated
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();
}
