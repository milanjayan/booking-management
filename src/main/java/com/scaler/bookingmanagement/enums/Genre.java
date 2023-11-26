package com.scaler.bookingmanagement.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;


public enum Genre {
    THRILLER,
    HORROR,
    COMEDY,
    ADVENTURE,
    ACTION,
    BIOGRAPHY,
    DRAMA,
    ROMANCE,
    CRIME
}
