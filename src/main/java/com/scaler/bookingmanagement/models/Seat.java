package com.scaler.bookingmanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.scaler.bookingmanagement.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "seats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat extends BaseModel {
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "screen_id")
    private Screen screen;
    private String row;
    private String column;
    @Enumerated
    private SeatType type;
}
