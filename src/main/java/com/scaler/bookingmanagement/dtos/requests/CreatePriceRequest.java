package com.scaler.bookingmanagement.dtos.requests;

import com.scaler.bookingmanagement.enums.MovieFeature;
import com.scaler.bookingmanagement.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePriceRequest {
    private Long theatreId;
    private MovieFeature feature;
    private SeatType seatType;
    private Double price;
}
