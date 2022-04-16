package com.company.controller;

import com.company.dto.FlightsInfoDto;
import com.company.repository.FlightsInfoRepository;
import com.company.service.FlightsInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FlightsInfoControllerTest {
    @Mock
    private FlightsInfoService flightsInfoService;
    @Mock
    private FlightsInfoRepository flightsInfoRepository;
    @InjectMocks
    private FlightsInfoController flightsInfoController;

    @Test
    void getAll() {
        FlightsInfoDto flightsInfoDto = FlightsInfoDto.builder()
                .airportName("asd")
                .build();
        List<FlightsInfoDto> flightsInfoDtoList = Mockito.spy(ArrayList.class);
        flightsInfoDtoList.add(flightsInfoDto);
        Mockito.when(flightsInfoService.getAll()).thenReturn(flightsInfoDtoList);
        Assertions.assertDoesNotThrow(() -> flightsInfoController.getAll());
    }

    @Test
    void getById() {
        FlightsInfoDto flightsInfoDto = FlightsInfoDto.builder()
                .id(1L)
                .build();
        List<FlightsInfoDto> flightsInfoDtoList = Mockito.spy(ArrayList.class);
        flightsInfoDtoList.add(flightsInfoDto);
        Mockito.when(flightsInfoService.getById(flightsInfoDto.getId())).thenReturn(flightsInfoDto);
        Assertions.assertDoesNotThrow(() -> flightsInfoController.getById(flightsInfoDto.getId()));
    }

    @Test
    void create() {
        FlightsInfoDto flightsInfoDto = FlightsInfoDto.builder()
                .id(1L)
                .airportName("BHL")
                .destinationPoint("Baku")
                .flightDate(LocalDate.ofEpochDay(2022 - 8 - 25))
                .flightTime("5 hour")
                .freeSeats(30L)
                .build();
        Mockito.when(flightsInfoService.create(new FlightsInfoDto(flightsInfoDto))).thenReturn(flightsInfoDto);
        Assertions.assertDoesNotThrow(() -> flightsInfoController.create(new FlightsInfoDto(flightsInfoDto)));
    }

    @Test
    void update() {
        FlightsInfoDto flightsInfoDto = FlightsInfoDto.builder()
                .id(1L)
                .airportName("BHL")
                .destinationPoint("Izmir")
                .flightDate(LocalDate.ofEpochDay(2022 - 8 - 25))
                .flightTime("8 hour")
                .freeSeats(20L)
                .build();
        Assertions.assertDoesNotThrow(() -> flightsInfoController.update(new FlightsInfoDto(flightsInfoDto)));
    }

    @Test
    void delete() {
        FlightsInfoDto flightsInfoDto = FlightsInfoDto.builder()
                .id(1L)
                .build();
        Assertions.assertDoesNotThrow(() -> flightsInfoController.delete(flightsInfoDto.getId()));
    }

    @Test
    void flightsInfoDto() {
        FlightsInfoDto flightsInfoDto = FlightsInfoDto.builder()
                .destinationPoint("Baku")
                .flightDate(LocalDate.ofEpochDay(2022 - 8 - 25))
                .build();
        Assertions.assertDoesNotThrow(() -> flightsInfoController.flightsInfoDto(flightsInfoDto.getDestinationPoint(), String.valueOf(flightsInfoDto.getFlightDate())));

    }
}