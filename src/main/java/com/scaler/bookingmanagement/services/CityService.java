package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.exceptions.CityNotFoundException;
import com.scaler.bookingmanagement.models.City;
import com.scaler.bookingmanagement.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {
    private CityRepository cityRepository;

    public City getCityByName(String name) {
        return cityRepository.findCityByName(name)
                .orElseThrow(() -> new CityNotFoundException(
                        "City with name: "+name+" not found"
                ));
    }
    public City getOrCreateCity(String name) {
        Optional<City> existingCity = cityRepository.findCityByName(name);
        if(existingCity.isPresent()) {
            return existingCity.get();
        }
        City city = City.builder().name(name).build();
        return cityRepository.save(city);
    }
}
