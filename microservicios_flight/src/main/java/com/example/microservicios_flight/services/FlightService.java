package com.example.microservicios_flight.services;

import com.example.microservicios_flight.dtos.*;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    FlightDto saveFlight(FlightToSaveDto flightToSaveDto);

    FlightDto getFlightbyID(Long id);

    FlightDto updateFlightbyID(Long id, FlightToSaveDto flight);

    void deleteFlightbyID(Long id);
}
