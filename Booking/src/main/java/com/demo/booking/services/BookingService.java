package com.demo.booking.services;

import com.demo.booking.dtos.BookingDto;
import com.demo.booking.dtos.BookingToSaveDto;

public interface BookingService {
    BookingDto saveBooking(BookingToSaveDto bookingToSaveDto);

    BookingDto getBookingById(Long id);

    BookingDto updateBookingById(Long id, BookingToSaveDto booking);

    void deleteBookingById(Long id);
}
