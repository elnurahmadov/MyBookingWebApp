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
public class FlightsInfoDto {

    Long id;

    LocalDate flightDate;

    String FlightTime;

    String destinationPoint;

    String departurePoint;

    String airportName;

    Long freeSeats;
}