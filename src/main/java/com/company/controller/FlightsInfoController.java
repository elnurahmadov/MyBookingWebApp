package com.company.controller;


import com.company.dto.FlightsInfoDto;
import com.company.service.FlightsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flightsInfo")
@RequiredArgsConstructor
public class FlightsInfoController {

    private final FlightsInfoService flightsInfoService;

    @GetMapping("/")
    public ResponseEntity<List<FlightsInfoDto>> getAll() {
        List<FlightsInfoDto> all = flightsInfoService.getAll();
        return ResponseEntity.ok(all);
    }


    @PostMapping
    public FlightsInfoDto create(@RequestBody FlightsInfoDto flightsInfoDto) {
        return flightsInfoService.create(flightsInfoDto);
    }

    @PutMapping
    public FlightsInfoDto update(@RequestBody FlightsInfoDto flightsInfoDto) {
        return flightsInfoService.update(flightsInfoDto);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        flightsInfoService.delete(id);
    }

    @GetMapping("/filter")
    public List<FlightsInfoDto> flightsInfoDtos(@RequestParam String destinationPoint,@RequestParam String flightDate){
        return flightsInfoService.flightsInfo(destinationPoint, flightDate);
    }


}
