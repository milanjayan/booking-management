package com.scaler.bookingmanagement.models;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class BaseModel {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
