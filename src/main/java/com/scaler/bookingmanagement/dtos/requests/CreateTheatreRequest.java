package com.scaler.bookingmanagement.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTheatreRequest {
    private String cityName;
    private String theatreName;
    private String theatreAddress;
}
