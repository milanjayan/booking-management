package com.scaler.bookingmanagement.repositories;

import com.scaler.bookingmanagement.models.Screen;
import com.scaler.bookingmanagement.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
    Optional<Screen> findScreenByTheatreAndNumber(Theatre theatre, String number);

}
