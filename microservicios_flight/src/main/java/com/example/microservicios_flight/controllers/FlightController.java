package com.example.microservicios_flight.controllers;

import com.example.microservicios_flight.dtos.*;
import com.example.microservicios_flight.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<FlightDto> saveFlight(@RequestBody FlightToSaveDto flightToSaveDto) {
        FlightDto savedFlight = flightService.saveFlight(flightToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable Long id) {
        FlightDto flightDto = flightService.getFlightbyID(id);
        return ResponseEntity.ok(flightDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDto> updateFlightById(@PathVariable Long id, @RequestBody FlightToSaveDto flightToSaveDto) {
        FlightDto updatedFlight = flightService.updateFlightbyID(id, flightToSaveDto);
        return ResponseEntity.ok(updatedFlight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightById(@PathVariable Long id) {
        flightService.deleteFlightbyID(id);
        return ResponseEntity.noContent().build();
    }
}
