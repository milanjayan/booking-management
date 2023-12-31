package com.scaler.bookingmanagement.repositories;

import com.scaler.bookingmanagement.enums.SeatType;
import com.scaler.bookingmanagement.models.Screen;
import com.scaler.bookingmanagement.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findSeatByScreenAndRowAndColumn(Screen screen, String row, String Column);
    List<Seat> findAllByScreen_Id(Long id);
}
