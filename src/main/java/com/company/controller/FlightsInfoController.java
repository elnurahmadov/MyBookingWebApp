package com.company.controller;

import com.company.dto.FlightsInfoDto;
import com.company.service.FlightsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flightInfos")
@RequiredArgsConstructor
public class FlightsInfoController {
    private final FlightsInfoService flightsInfoService;

    @GetMapping("/list")
    public ResponseEntity<List<FlightsInfoDto>> getAll() {
        List<FlightsInfoDto> all = flightsInfoService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/list/{id}")
    public FlightsInfoDto getById(@PathVariable Long id) {
        return flightsInfoService.getById(id);
    }

    @PostMapping("/create")
    public FlightsInfoDto create(@RequestBody FlightsInfoDto flightsInfoDto) {
        return flightsInfoService.create(flightsInfoDto);
    }

    @PutMapping("/update")
    public FlightsInfoDto update(@RequestBody FlightsInfoDto flightsInfoDto) {
        return flightsInfoService.update(flightsInfoDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        flightsInfoService.delete(id);
    }

    @GetMapping("/filter")
    public List<FlightsInfoDto> flightsInfoDto(@RequestParam String destinationPoint, @RequestParam String flightDate) {
        return flightsInfoService.flightsInfo(destinationPoint, flightDate);
    }
}