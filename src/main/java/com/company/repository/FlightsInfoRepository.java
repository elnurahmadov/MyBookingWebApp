package com.company.repository;

import com.company.model.FlightsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightsInfoRepository extends JpaRepository<FlightsInfo, Long> {

    List<FlightsInfo> findByDestinationPointAndFlightDate(String destinationPoint, LocalDate flightDate);
}
