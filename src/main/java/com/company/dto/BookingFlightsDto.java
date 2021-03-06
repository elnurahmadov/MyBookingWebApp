package com.company.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingFlightsDto {

    Long id;

    LocalDate flightDate;

    String flightTime;

    String destinationPoint;

    String departurePoint;

    Long freeSeats;
}
