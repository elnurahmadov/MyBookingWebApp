package com.company.service.serviceImpl;

import com.company.dto.FlightsInfoDto;
import com.company.model.FlightsInfo;
import com.company.repository.FlightsInfoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FlightsServiceTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private FlightsInfoRepository flightsRepository;

    @InjectMocks
    private FlightsInfoServiceImpl flightService;

    @Test
    void getAll() {
        FlightsInfo flightsDto = FlightsInfo.builder()
                .airportName("AHL")
                .destinationPoint("Baku")
                .flightDate(LocalDate.ofEpochDay(2022 - 8 - 25))
                .flightTime("21:00")
                .freeSeats(30L)
                .build();
        List<FlightsInfo> flightsDtoList = Mockito.spy(ArrayList.class);
        flightsDtoList.add(flightsDto);
        Mockito.when(flightsRepository.findAll()).thenReturn(flightsDtoList);

        Assertions.assertDoesNotThrow(() -> flightService.getAll());
    }

    @Test
    void create() {
        FlightsInfo flights = FlightsInfo.builder()
                .id(2L)
                .airportName("AHL")
                .destinationPoint("Baku")
                .flightDate(LocalDate.ofEpochDay(2022 - 8 - 25))
                .flightTime("21:00")
                .freeSeats(30L)
                .build();
        Mockito.when(flightsRepository.save(flights)).thenReturn(flights);

        Assertions.assertDoesNotThrow(() -> flightService.create(modelMapper.map(flights, FlightsInfoDto.class)));
    }


    @Test
    void update() {
        FlightsInfoDto flightsDto = FlightsInfoDto.builder()
                .id(2L)
                .airportName("AHL")
                .destinationPoint("Baku")
                .flightDate(LocalDate.ofEpochDay(2022 - 8 - 24))
                .flightTime("21:00")
                .freeSeats(30L)
                .build();

        Assertions.assertDoesNotThrow(() -> flightService.create(new FlightsInfoDto(flightsDto)));
    }

    @Test
    void delete() {
        FlightsInfoDto flightsDto = FlightsInfoDto.builder()
                .id(2L)
                .build();

        Assertions.assertDoesNotThrow(() -> flightService.delete(flightsDto.getId()));
    }

    @Test
    void flightsInfo() {

        FlightsInfoDto flightsInfoDto = FlightsInfoDto.builder()
                .destinationPoint("Baku")
                .flightDate(LocalDate.of(2022, 2, 25))
                .build();
        List<FlightsInfoDto> flightsDtoList = Mockito.spy(ArrayList.class);
        flightsDtoList.add(flightsInfoDto);
        Mockito.when(flightsRepository.findByDestinationPointAndFlightDate(flightsInfoDto.getDestinationPoint(),
                flightsInfoDto.getFlightDate()));

        Assertions.assertDoesNotThrow(() -> flightService.flightsInfo(flightsInfoDto.getDestinationPoint()
                , String.valueOf(flightsInfoDto.getFlightDate())));
    }
}