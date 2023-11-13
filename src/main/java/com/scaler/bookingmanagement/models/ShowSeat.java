package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "showseats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated
    private SeatStatus status;
}
