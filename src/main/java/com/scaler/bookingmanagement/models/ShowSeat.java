package com.scaler.bookingmanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.scaler.bookingmanagement.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Entity
@Table(name = "showseats")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class ShowSeat extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonBackReference
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;
}
