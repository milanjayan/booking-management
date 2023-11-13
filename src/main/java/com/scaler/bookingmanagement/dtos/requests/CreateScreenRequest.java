package com.scaler.bookingmanagement.dtos.requests;
import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
@AllArgsConstructor
public class CreateScreenRequest {
    private String cityName;
    private String theatreName;
    private String screenNumber;
}
