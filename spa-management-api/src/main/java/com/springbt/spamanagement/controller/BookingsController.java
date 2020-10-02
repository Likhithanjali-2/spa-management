package com.springbt.spamanagement.controller;

import com.springbt.spamanagement.exception.ResourceNotFoundException;
import com.springbt.spamanagement.model.Booking;
import com.springbt.spamanagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/spa")
public class BookingsController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings(){

        return  bookingRepository.findAll();
    }

    @PostMapping("/bookings")
    public Booking createBooking(@Valid @RequestBody  Booking booking){
        booking.setStatus("Created");
        return  bookingRepository.save(booking);
    }

    @GetMapping("/bookings/{id}")
    public Booking getBookingById(@PathVariable(value = "id") Long bookingId)
            throws ResourceNotFoundException {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking details not found for given id :"+bookingId));
        return booking;
    }

}
