package com.demo.booking.services;

import com.demo.booking.dtos.BookingDto;
import com.demo.booking.dtos.BookingMapper;
import com.demo.booking.dtos.BookingToSaveDto;
import com.demo.booking.models.Booking;
import com.demo.booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private BookingMapper bookingMapper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public BookingDto saveBooking(BookingToSaveDto bookingToSaveDto) {
        Booking booking = bookingMapper.saveDtoToEntity(bookingToSaveDto);
        return bookingMapper.toDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDto getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        return bookingMapper.toDto(booking);
    }

    @Override
    public BookingDto updateBookingById(Long id, BookingToSaveDto booking) {
        return bookingRepository.findById(id).map(booking1 -> {
                booking1.setFlightNumber(booking.flightNumber());
                Booking saveBooking = bookingRepository.save(booking1);
                return bookingMapper.toDto(saveBooking);}).orElseThrow();
    }

    @Override
    public void deleteBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        bookingRepository.delete(booking);
    }
}
