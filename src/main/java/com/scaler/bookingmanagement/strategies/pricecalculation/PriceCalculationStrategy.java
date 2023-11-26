package com.scaler.bookingmanagement.strategies.pricecalculation;

import com.scaler.bookingmanagement.models.Ticket;
import org.springframework.stereotype.Component;

@Component
public interface PriceCalculationStrategy {
    Double calculateAmount(Ticket ticket);
}
