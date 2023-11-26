package com.scaler.bookingmanagement.strategies.pricecalculation;

import com.scaler.bookingmanagement.enums.SeatType;
import com.scaler.bookingmanagement.exceptions.InvalidSeatTypeException;
import com.scaler.bookingmanagement.models.Ticket;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("fixedPriceCalculation")
@Primary
public class FixedPriceCalculationStrategy implements PriceCalculationStrategy {
    @Override
    public Double calculateAmount(Ticket ticket) {
        return ticket.getSeats().stream().mapToDouble(
                seat -> getSeatPrice(seat.getSeat().getType())
        ).sum();
    }

    private static double getSeatPrice(SeatType type) {
        switch(type) {
            case GOLD -> {return 150;}
            case PLATINUM -> {return 300;}
            case DIAMOND -> {return 700;}
            case VIP -> {return 1000;}
        }
        throw new InvalidSeatTypeException("Seat type: "+type+" is invalid");
    }

}
