package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.PaymentMode;
import com.scaler.bookingmanagement.enums.PaymentStatus;

public class Payment {
    private Double amount;
    private PaymentMode mode;
    private PaymentStatus status;
}
