package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "seats")
public class Seat extends BaseModel {
    private String number;
    @Enumerated
    private SeatType type;
}
