package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tickets")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Ticket extends BaseModel {
    @ManyToOne
    private Customer customer;
    private Double amount;
    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
}
