package com.example.microservicios_flight.dtos;

import com.example.microservicios_flight.models.Flight;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T17:28:47-0500",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class FlightMapperImpl implements FlightMapper {

    @Override
    public FlightDto toDto(Flight flight) {
        if ( flight == null ) {
            return null;
        }

        Long id = null;
        Long flightNumber = null;
        String origin = null;
        String destination = null;
        String departureTime = null;

        id = flight.getId();
        flightNumber = flight.getFlightNumber();
        origin = flight.getOrigin();
        destination = flight.getDestination();
        departureTime = flight.getDepartureTime();

        FlightDto flightDto = new FlightDto( id, flightNumber, origin, destination, departureTime );

        return flightDto;
    }

    @Override
    public Flight toEntity(FlightDto flightDto) {
        if ( flightDto == null ) {
            return null;
        }

        Flight.FlightBuilder flight = Flight.builder();

        flight.id( flightDto.id() );
        flight.flightNumber( flightDto.flightNumber() );
        flight.origin( flightDto.origin() );
        flight.destination( flightDto.destination() );
        flight.departureTime( flightDto.departureTime() );

        return flight.build();
    }

    @Override
    public Flight saveDtoToEntity(FlightToSaveDto flightToSaveDto) {
        if ( flightToSaveDto == null ) {
            return null;
        }

        Flight.FlightBuilder flight = Flight.builder();

        flight.id( flightToSaveDto.id() );
        flight.flightNumber( flightToSaveDto.flightNumber() );
        flight.origin( flightToSaveDto.origin() );
        flight.destination( flightToSaveDto.destination() );
        flight.departureTime( flightToSaveDto.departureTime() );

        return flight.build();
    }
}
