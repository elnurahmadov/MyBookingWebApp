package com.company.serviceImpl;

import com.company.dto.FlightsInfoDto;
import com.company.model.FlightsInfo;
import com.company.repository.BookingFlightsRepository;
import com.company.repository.FlightsInfoRepository;
import com.company.repository.UserRepository;
import com.company.service.FlightsInfoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightsInfoServiceImpl implements FlightsInfoService {

    private final ModelMapper modelMapper;

    private final FlightsInfoRepository flightsInfoRepository;

    private final UserRepository userRepository;

    private final BookingFlightsRepository bookingFlightsRepository;

    @Override
    public List<FlightsInfoDto> getAll() {
        List<com.company.model.FlightsInfo> all = flightsInfoRepository.findAll();
        return all.stream().map(flightsInfo -> modelMapper.map(flightsInfo, FlightsInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FlightsInfoDto create(FlightsInfoDto airportDto) {
        com.company.model.FlightsInfo flightsInfo = modelMapper.map(airportDto, com.company.model.FlightsInfo.class);
        com.company.model.FlightsInfo save = flightsInfoRepository.save(flightsInfo);
        return modelMapper.map(save, FlightsInfoDto.class);
    }

    @Override
    public FlightsInfoDto getById(Long id) {
        FlightsInfo byId = flightsInfoRepository.getById(id);
        FlightsInfoDto map = modelMapper.map(byId, FlightsInfoDto.class);
        return map;
    }

    @Override
    public FlightsInfoDto update(FlightsInfoDto airportDto) {
        com.company.model.FlightsInfo flightsInfo = flightsInfoRepository.findById(airportDto.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        flightsInfo.setAirportName(airportDto.getAirportName());
        flightsInfo.setDeparturePoint(airportDto.getDeparturePoint());
        flightsInfo.setDestinationPoint(airportDto.getDestinationPoint());
        flightsInfo.setFlightDate(airportDto.getFlightDate());
        flightsInfo.setFlightTime(airportDto.getFlightTime());
        flightsInfo.setFreeSeats(airportDto.getFreeSeats());

        com.company.model.FlightsInfo save = flightsInfoRepository.save(flightsInfo);
        return modelMapper.map(save, FlightsInfoDto.class);

    }

    @Override
    public void delete(Long id) {
        flightsInfoRepository.deleteById(id);
    }

    @Override
    public List<FlightsInfoDto> flightsInfo(String destinationPoint, String flightDate) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate date = LocalDate.parse(flightDate, dateTimeFormatter);

        List<FlightsInfo> flightsInfos = flightsInfoRepository.findByDestinationPointAndFlightDate(destinationPoint, date);

        return flightsInfos.stream()
                .map(flightsInfo -> modelMapper.map(flightsInfo, FlightsInfoDto.class))
                .collect(Collectors.toList());
    }
}
