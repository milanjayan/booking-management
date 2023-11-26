package com.scaler.bookingmanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Entity
@Table(name = "coupons")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Coupon extends BaseModel {
     private String number;
     private Double discount;
}
