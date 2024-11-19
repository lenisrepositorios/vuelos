package com.example.microservicios_flight.dtos;

public record FlightToSaveDto(Long id,
                              Long flightNumber,
                              String origin,
                              String destination,
                              String departureTime) {
}
