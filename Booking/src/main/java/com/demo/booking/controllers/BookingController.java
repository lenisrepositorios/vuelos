package com.demo.booking.controllers;

import com.demo.booking.dtos.BookingDto;
import com.demo.booking.dtos.BookingToSaveDto;
import com.demo.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingDto> saveBooking(@RequestBody BookingToSaveDto bookingToSaveDto) {
        BookingDto savedBooking = bookingService.saveBooking(bookingToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable Long id) {
        BookingDto bookingDto = bookingService.getBookingById(id);
        return ResponseEntity.ok(bookingDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> updateBookingById(@PathVariable Long id, @RequestBody BookingToSaveDto bookingToSaveDto) {
        BookingDto updatedBooking = bookingService.updateBookingById(id, bookingToSaveDto);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingById(@PathVariable Long id) {
        bookingService.deleteBookingById(id);
        return ResponseEntity.noContent().build();
    }
}
