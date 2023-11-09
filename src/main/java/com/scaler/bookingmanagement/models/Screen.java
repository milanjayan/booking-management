package com.scaler.bookingmanagement.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "screens")
public class Screen extends BaseModel {
    private String number;
    @OneToMany
    private List<Seat> seats = new ArrayList<>();
}
