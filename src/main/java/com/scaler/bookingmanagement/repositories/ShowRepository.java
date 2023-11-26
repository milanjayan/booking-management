package com.scaler.bookingmanagement.repositories;

import com.scaler.bookingmanagement.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findAllByTheatreCityNameAndTheatreNameAndMovieName(String cityName, String theatreName, String movieName);
}
