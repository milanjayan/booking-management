package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.strategies.pricecalculation.PriceCalculationStrategy;
import com.scaler.bookingmanagement.dtos.requests.CreateTicketRequest;
import com.scaler.bookingmanagement.enums.SeatStatus;
import com.scaler.bookingmanagement.enums.TicketStatus;
import com.scaler.bookingmanagement.exceptions.ShowSeatNotAvailableException;
import com.scaler.bookingmanagement.exceptions.TicketNotFoundException;
import com.scaler.bookingmanagement.models.Customer;
import com.scaler.bookingmanagement.models.Show;
import com.scaler.bookingmanagement.models.ShowSeat;
import com.scaler.bookingmanagement.models.Ticket;
import com.scaler.bookingmanagement.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {
    private TicketRepository ticketRepository;
    private CustomerService customerService;
    private ShowService showService;
    private ShowSeatService showSeatService;

    @Autowired
    @Qualifier("variablePriceCalculation")
    private PriceCalculationStrategy priceCalculationStrategy;

    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException("Ticket with id: "+id+" not found"));
    }

    public Ticket createTicket(CreateTicketRequest request) {
        Customer customer = customerService.getById(request.getCustomerId());
        Show show = showService.getShowById(request.getShowId());

        List<ShowSeat> lockedSeats = lockedSeats(request);

        Ticket ticket = Ticket.builder()
                .customer(customer)
                .seats(lockedSeats)
                .show(show)
                .status(TicketStatus.PENDING)
                .build();

        Double amount = priceCalculationStrategy.calculateAmount(ticket);
        ticket = ticket.toBuilder().amount(amount).build();
        return ticketRepository.save(ticket);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> lockedSeats(CreateTicketRequest request) {
        List<ShowSeat> showSeats = request.getShowSeatIds().stream().map(
                showSeatId -> showSeatService.getShowSeat(showSeatId)
        ).toList();

       showSeats.forEach(showSeat -> {
           if(showSeat.getStatus() != SeatStatus.AVAILABLE) {
               throw new ShowSeatNotAvailableException("Show seat with id: "+showSeat.getId()+" not available");
           }
       });

       List<ShowSeat> lockedSeats = showSeats.stream()
               .peek(showSeat -> showSeat.setStatus(SeatStatus.LOCKED))
               .toList();
        return showSeatService.saveAll(lockedSeats);
    }
}
