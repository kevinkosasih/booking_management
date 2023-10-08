package id.ticket.bookingManagement.controller;

import id.ticket.bookingManagement.models.BookingModel;
import id.ticket.bookingManagement.service.BookingService;
import id.ticket.bookingManagement.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingModel request) {
        Booking booking = bookingService.createBooking(
                request.getUserId(),
                request.getConcertId(),
                request.getTotalTicket()
        );
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.getUserBookings(userId);
        return ResponseEntity.ok(bookings);
    }
}
