package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.MovieFeature;
import com.scaler.bookingmanagement.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prices")
@DynamicUpdate
public class Price extends BaseModel {
    @ManyToOne
    private Theatre theatre;
    @Enumerated
    private MovieFeature feature;
    @Enumerated
    private SeatType seatType;
    private Double price;
}
