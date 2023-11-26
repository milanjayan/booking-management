package com.scaler.bookingmanagement.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreateTicketRequest {
    private Long showId;
    private Long customerId;
    private List<Long> showSeatIds;
}
