package com.scaler.bookingmanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer extends BaseModel {
    private String fullName;
    private String city;
    private String phone;
    private String email;
    @OneToOne
    private User user;
}
