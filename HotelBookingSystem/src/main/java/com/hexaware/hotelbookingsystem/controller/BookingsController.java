package com.hexaware.hotelbookingsystem.controller;
/*
 *Controller  for Bookings
 *Author : Prerna
 *Date: 2024-11-16
 * */

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hotelbookingsystem.dto.BookingsDto;
import com.hexaware.hotelbookingsystem.entities.Bookings;
import com.hexaware.hotelbookingsystem.entities.Bookings.BookingStatus;
import com.hexaware.hotelbookingsystem.exception.BookingNotFoundException;
import com.hexaware.hotelbookingsystem.service.IBookingsService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/bookings")
public class BookingsController {

    @Autowired
    IBookingsService service;

    @PostMapping("/create")
    public Bookings createBooking(@RequestBody BookingsDto bookingdto) {
        return service.createBooking(bookingdto);
    }

    @GetMapping("/getbyid/{bookingId}")
    public Bookings getBookingById(@PathVariable Integer bookingId) {
        Bookings booking = service.getBookingById(bookingId);
        if (booking == null) {
            throw new BookingNotFoundException("Booking not found for ID: " + bookingId);
        }
        return booking;
    }


    @DeleteMapping("/cancel/{bookingId}")
    public String cancelBooking(@PathVariable Integer bookingId) {
        service.cancelBookingById(bookingId);
        return "Booking with ID " + bookingId + " canceled.";
    }

    @GetMapping("/getbystatus")
    public List<Bookings> getBookingsByStatus(@RequestParam("status") BookingStatus status) {
        return service.getBookingsByStatus(status);
    }

  @GetMapping("/getall")
//  @PreAuthorize("hasAuthority('ADMIN')")
  public List<Bookings> getAllBookings() {
    return service.getAllBookings();
  }
}
