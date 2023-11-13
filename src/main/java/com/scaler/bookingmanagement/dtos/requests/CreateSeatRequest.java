package com.scaler.bookingmanagement.dtos.requests;

import com.scaler.bookingmanagement.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateSeatRequest {
    private String cityName;
    private String theatreName;
    private String screenNumber;
    private String row;
    private String column;
    private SeatType seatType;
}
