package com.example.microservicios_flight.dtos;

import com.example.microservicios_flight.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    FlightDto toDto(Flight flight);
    Flight toEntity(FlightDto flightDto);

    Flight saveDtoToEntity(FlightToSaveDto flightToSaveDto);
}
