package com.org.photography.app.rest;

import com.org.photography.app.entity.Booking;
import com.org.photography.app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingRestController {
    private BookingService bookingService;

    @Autowired
    public BookingRestController(BookingService theBookingService) {
        bookingService = theBookingService;
    }

    @GetMapping("/bookings")
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/bookings/{customerId}")
    public List<Object[]> getBooking(@PathVariable int customerId) {
        List<Object[]> bookings = bookingService.findByCustomerId(customerId);
        if (bookings == null||bookings.isEmpty()) {
            throw new RuntimeException("Booking not found -" + customerId);

        }
        return bookings;
    }

    @PostMapping("/bookings")
    public Booking addBooking(@RequestBody Booking booking) {
        booking.setBookingId(0);
        bookingService.save(booking);
        return booking;
    }

    @PutMapping("/bookings")
    public Booking updateBooking(@RequestBody Booking booking) {
        bookingService.save(booking);
        return booking;
    }

    @DeleteMapping("/bookings/{bookingId}")
    public String deleteBooking(@PathVariable int bookingId) {
        Booking tempBooking = bookingService.findById(bookingId);
        if (tempBooking == null) {
            throw new RuntimeException("Booking id not found "+bookingId);
        }
        bookingService.deleteById(bookingId);
        return "Deleted Booking with id - "+bookingId;
    }
}
