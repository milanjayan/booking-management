package com.scaler.bookingmanagement.repositories;

import com.scaler.bookingmanagement.enums.MovieFeature;
import com.scaler.bookingmanagement.enums.SeatType;
import com.scaler.bookingmanagement.models.Price;
import com.scaler.bookingmanagement.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    Optional<Price> findTopByTheatreAndSeatTypeAndFeatureInOrderByPriceDesc(Theatre theatre, SeatType seatType, List<MovieFeature> features);
}
