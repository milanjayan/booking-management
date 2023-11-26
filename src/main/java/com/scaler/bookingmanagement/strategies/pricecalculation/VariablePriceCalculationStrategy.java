package com.scaler.bookingmanagement.strategies.pricecalculation;

import com.scaler.bookingmanagement.models.Price;
import com.scaler.bookingmanagement.models.ShowSeat;
import com.scaler.bookingmanagement.models.Theatre;
import com.scaler.bookingmanagement.models.Ticket;
import com.scaler.bookingmanagement.services.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component("variablePriceCalculation")
public class VariablePriceCalculationStrategy implements PriceCalculationStrategy {

    private PriceService priceService;

    @Override
    public Double calculateAmount(Ticket ticket) {
        Theatre theatre = ticket.getShow().getTheatre();
        List<ShowSeat> showSeats = ticket.getSeats();
        return showSeats.stream().mapToDouble(
                showSeat -> priceService.getPriceByTheatreAndSeatTypeAndFeatures(theatre, showSeat.getSeat().getType(), ticket.getShow().getFeatures())
        ).sum();
    }
}
