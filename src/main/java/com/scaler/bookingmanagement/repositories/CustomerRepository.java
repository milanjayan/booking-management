package com.scaler.bookingmanagement.repositories;

import com.scaler.bookingmanagement.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerByEmail(String Email);
    Optional<Customer> findCustomerByPhone(String phone);
}
