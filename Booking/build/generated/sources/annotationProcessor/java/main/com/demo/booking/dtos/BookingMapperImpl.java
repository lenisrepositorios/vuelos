package com.demo.booking.dtos;

import com.demo.booking.models.Booking;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T18:07:00-0500",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingDto toDto(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        Long id = null;
        Long flightNumber = null;
        String passengerName = null;

        id = booking.getId();
        flightNumber = booking.getFlightNumber();
        passengerName = booking.getPassengerName();

        BookingDto bookingDto = new BookingDto( id, flightNumber, passengerName );

        return bookingDto;
    }

    @Override
    public Booking toEntity(BookingDto bookingDto) {
        if ( bookingDto == null ) {
            return null;
        }

        Booking.BookingBuilder booking = Booking.builder();

        booking.id( bookingDto.id() );
        booking.flightNumber( bookingDto.flightNumber() );
        booking.passengerName( bookingDto.passengerName() );

        return booking.build();
    }

    @Override
    public Booking saveDtoToEntity(BookingToSaveDto bookingToSaveDto) {
        if ( bookingToSaveDto == null ) {
            return null;
        }

        Booking.BookingBuilder booking = Booking.builder();

        booking.id( bookingToSaveDto.id() );
        booking.flightNumber( bookingToSaveDto.flightNumber() );
        booking.passengerName( bookingToSaveDto.passengerName() );

        return booking.build();
    }
}
