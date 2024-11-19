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

    @GetMapping("/{flightNumber}")
    public ResponseEntity<FlightDto> getFlightByFlightNumber(@PathVariable Long flightNumber) {
        FlightDto flight = flightService.getFlightbyID(flightNumber);
        return ResponseEntity.ok(flight);
    }

    @PutMapping("/{flightNumber}")
    public ResponseEntity<FlightDto> updateFlightByFlightNumber(@PathVariable Long flightNumber, @RequestBody FlightToSaveDto flightToSaveDto) {
        FlightDto updatedFlight = flightService.updateFlightbyID(flightNumber, flightToSaveDto);
        return ResponseEntity.ok(updatedFlight);
    }

    @DeleteMapping("/{flightNumber}")
    public ResponseEntity<Void> deleteFlightById(@PathVariable Long flightNumber) {
        flightService.deleteFlightbyID(flightNumber);
        return ResponseEntity.noContent().build();
    }
}
