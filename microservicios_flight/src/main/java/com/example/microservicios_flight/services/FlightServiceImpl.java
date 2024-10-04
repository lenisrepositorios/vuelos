package com.example.microservicios_flight.services;

import com.example.microservicios_flight.dtos.*;
import com.example.microservicios_flight.models.*;
import com.example.microservicios_flight.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    private final FlightRepository flightRepository;
    private FlightMapper flightMapper;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, FlightMapper flightMapper){
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    @Override
    public FlightDto saveFlight(FlightToSaveDto flightToSaveDto){
        Flight flight = flightMapper.saveDtoToEntity(flightToSaveDto);
        return flightMapper.toDto(flightRepository.save(flight));
    }

    @Override
    public FlightDto getFlightbyID(Long id){
        Flight flight = flightRepository.findById(id).orElseThrow();
        return flightMapper.toDto(flight);
    }

    @Override
    public FlightDto updateFlightbyID(Long id, FlightToSaveDto flight){
        return flightRepository.findById(id).map(flight1 ->{
            flight1.setFlightNumber(flight.flightNumber());
            Flight savedFlight = flightRepository.save(flight1);
            return flightMapper.toDto(savedFlight);
        }).orElseThrow();
    }

    @Override
    public void deleteFlightbyID(Long id){
        Flight flight = flightRepository.findById(id).orElseThrow();
        flightRepository.delete(flight);
    }

}
