package com.company.service;

import com.company.dto.FlightsInfoDto;

import java.util.List;

public interface FlightsInfoService {
    List<FlightsInfoDto> getAll();

    FlightsInfoDto create(FlightsInfoDto flightsInfoDto);

    FlightsInfoDto getById(Long id);

    FlightsInfoDto update(FlightsInfoDto flightsInfoDto);

    void delete(Long id);

    List<FlightsInfoDto> flightsInfo(String destinationPoint, String flightDate);

}