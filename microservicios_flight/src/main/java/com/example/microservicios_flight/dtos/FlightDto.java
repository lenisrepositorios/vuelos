package com.example.microservicios_flight.dtos;

public record FlightDto(Long id,
        Long flightNumber,
        String origin,
        String destination,
        String departureTime) {
}
