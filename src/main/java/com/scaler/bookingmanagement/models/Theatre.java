package com.scaler.bookingmanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "theatres")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theatre extends BaseModel {
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @OneToMany(mappedBy = "theatre")
    @JsonManagedReference
    private List<Screen> screens = new ArrayList<>();
    @OneToMany
    @JsonManagedReference
    private List<Show> shows = new ArrayList<>();
}
