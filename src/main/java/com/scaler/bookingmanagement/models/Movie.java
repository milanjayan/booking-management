package com.scaler.bookingmanagement.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.scaler.bookingmanagement.enums.Genre;
import com.scaler.bookingmanagement.enums.Language;
import com.scaler.bookingmanagement.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movies")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Movie extends BaseModel {
    private String name;
    private String duration;
    private Double rating;
    @ElementCollection
    @Enumerated
    private List<Language> languages = new ArrayList<>();
    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private List<Show> shows = new ArrayList<>();
}
