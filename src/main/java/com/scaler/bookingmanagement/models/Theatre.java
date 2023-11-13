package com.scaler.bookingmanagement.models;

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
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens = new ArrayList<>();
    @OneToMany
    private List<Show> shows = new ArrayList<>();
}
