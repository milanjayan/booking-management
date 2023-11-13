package com.scaler.bookingmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookingManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingManagementApplication.class, args);
    }

}
