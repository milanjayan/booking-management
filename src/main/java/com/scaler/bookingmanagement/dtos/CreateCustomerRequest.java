package com.scaler.bookingmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCustomerRequest {
    private String fullName;
    private String city;
    private String phone;
    private String email;
    private String userName;
    private String password;
}
