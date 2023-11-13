package com.scaler.bookingmanagement.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "screens")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Screen extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;
    private String number;
    @OneToMany(mappedBy = "screen")
    private List<Seat> seats = new ArrayList<>();
}
