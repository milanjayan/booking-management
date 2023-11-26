package com.scaler.bookingmanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "theatres")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Theatre extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference
    private City city;
    private String name;
    private String address;
    @OneToMany(mappedBy = "theatre")
    @JsonManagedReference
    private List<Screen> screens;
    @OneToMany(mappedBy = "theatre")
    @JsonManagedReference
    private List<Show> shows = new ArrayList<>();
}
