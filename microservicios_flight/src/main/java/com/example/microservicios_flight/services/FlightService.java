package com.example.microservicios_flight.services;

import com.example.microservicios_flight.dtos.*;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    FlightDto saveFlight(FlightToSaveDto flightToSaveDto);

    FlightDto getFlightbyID(Long flightNumber);

    FlightDto updateFlightbyID(Long flightNumber, FlightToSaveDto flight);

    void deleteFlightbyID(Long flightNumber);
}
