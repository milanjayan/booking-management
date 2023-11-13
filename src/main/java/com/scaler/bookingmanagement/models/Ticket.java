package com.scaler.bookingmanagement.models;

import com.scaler.bookingmanagement.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tables")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseModel {
    private int number;
    @ManyToOne
    private User user;
    private Double amount;
    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();
    @ManyToOne
    private Show show;
    @Enumerated
    private TicketStatus status;
}
