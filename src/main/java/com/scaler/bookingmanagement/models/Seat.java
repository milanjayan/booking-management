package com.scaler.bookingmanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.scaler.bookingmanagement.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Entity
@Table(name = "seats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Seat extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "screen_id")
    @JsonBackReference
    private Screen screen;
    @Column(name = "seat_row")
    private String row;
    @Column(name = "seat_column")
    private String column;
    @Enumerated
    private SeatType type;
}
