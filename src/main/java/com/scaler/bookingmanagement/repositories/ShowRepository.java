package com.scaler.bookingmanagement.repositories;

import com.scaler.bookingmanagement.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
