package com.company.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingFlights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate flightDate;

    String FlightTime;

    String destinationPoint;

    String departurePoint;

    Long freeSeats;
}
