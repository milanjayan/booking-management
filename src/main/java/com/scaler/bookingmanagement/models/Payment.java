package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.PaymentMode;
import com.scaler.bookingmanagement.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "payments")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends BaseModel {
    private Double amount;
    @Enumerated
    private PaymentMode mode;
    @Enumerated
    private PaymentStatus status;
}
