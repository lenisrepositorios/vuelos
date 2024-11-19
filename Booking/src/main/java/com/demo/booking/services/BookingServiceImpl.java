package com.demo.booking.services;

import com.demo.booking.dtos.BookingDto;
import com.demo.booking.dtos.BookingMapper;
import com.demo.booking.dtos.BookingToSaveDto;
import com.demo.booking.models.Booking;
import com.demo.booking.models.Flight;
import com.demo.booking.repositories.BookingRepository;
import com.demo.booking.controllers.FlightServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final FlightServiceClient flightServiceClient;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper, FlightServiceClient flightServiceClient) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.flightServiceClient = flightServiceClient;
    }

    @Override
    public BookingDto saveBooking(BookingToSaveDto bookingToSaveDto) {
        Flight flight = flightServiceClient.getFlightByFlightNumber(bookingToSaveDto.flightNumber());
        if (flight == null) {
            throw new RuntimeException("Vuelo no encontrado");
        }

        Booking booking = bookingMapper.saveDtoToEntity(bookingToSaveDto);
        booking.setFlightNumber(flight.getFlightNumber());
        return bookingMapper.toDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDto getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        return bookingMapper.toDto(booking);
    }

    @Override
    public BookingDto updateBookingById(Long id, BookingToSaveDto bookingToSaveDto) {
        return bookingRepository.findById(id).map(existingBooking -> {

            Flight flight = flightServiceClient.getFlightByFlightNumber(bookingToSaveDto.flightNumber());
            if (flight == null) {
                throw new RuntimeException("Vuelo no encontrado");
            }

            existingBooking.setFlightNumber(flight.getFlightNumber());
            existingBooking.setPassengerName(bookingToSaveDto.passengerName());
            return bookingMapper.toDto(bookingRepository.save(existingBooking));
        }).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    public void deleteBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        bookingRepository.delete(booking);
    }
}
