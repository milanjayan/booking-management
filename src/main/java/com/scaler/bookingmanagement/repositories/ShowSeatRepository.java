package com.scaler.bookingmanagement.repositories;

import com.scaler.bookingmanagement.models.Seat;
import com.scaler.bookingmanagement.models.Show;
import com.scaler.bookingmanagement.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    Optional<ShowSeat> findShowSeatByShowAndSeat(Show show, Seat seat);
    List<ShowSeat> findAllByShow_Id(Long showId);
}
