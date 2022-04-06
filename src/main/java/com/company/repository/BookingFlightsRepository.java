package com.company.repository;

import com.company.model.BookingFlights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingFlightsRepository extends JpaRepository<BookingFlights, Long> {
}

