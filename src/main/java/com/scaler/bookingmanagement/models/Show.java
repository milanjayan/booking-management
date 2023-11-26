package com.scaler.bookingmanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.scaler.bookingmanagement.enums.Language;
import com.scaler.bookingmanagement.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "shows")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Show extends BaseModel {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    private Movie movie;
    @Enumerated
    private Language language;
    @ManyToOne
    @JsonBackReference
    private Theatre theatre;
    @ManyToOne
    private Screen screen;
    @OneToMany(mappedBy = "show")
    @JsonManagedReference
    private List<ShowSeat> showSeats;
}
