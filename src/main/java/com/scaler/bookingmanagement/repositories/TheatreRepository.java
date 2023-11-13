package com.scaler.bookingmanagement.repositories;

import com.scaler.bookingmanagement.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    Optional<Theatre> findTheatreByName(String name);
    Optional<Theatre> findTheatreByNameAndCityName(String theatreName, String cityName);
    Optional<Theatre> findTheatreByNameAndCityNameAndAddress(String theatreName, String cityName, String address);
}
