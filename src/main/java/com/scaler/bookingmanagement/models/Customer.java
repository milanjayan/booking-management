package com.scaler.bookingmanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Entity
@Table(name = "customers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Customer extends BaseModel {
    private String fullName;
    private String city;
    private String phone;
    private String email;
    @OneToOne
    private User user;
}
