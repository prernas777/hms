package com.hexaware.hotelbookingsystem.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hotelbookingsystem.dto.BookingsDto;
import com.hexaware.hotelbookingsystem.entities.Bookings;
import com.hexaware.hotelbookingsystem.entities.Bookings.BookingStatus;

@SpringBootTest
class BookingsServiceImpTest {

    @Autowired
    IBookingsService service;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        // You can add setup logic here if needed
    }

    @Test
    @Disabled
    void testCreateBooking() {
        // Prepare sample BookingDto
        BookingsDto bookingDto = new BookingsDto();
        bookingDto.setBookingId(1);
        bookingDto.setCheckInDate(java.time.LocalDate.of(2024, 12, 1));
        bookingDto.setCheckOutDate(java.time.LocalDate.of(2024, 12, 5));
        bookingDto.setTotalAmount(5000.0);
        bookingDto.setBookingStatus(BookingsDto.BookingStatus.PENDING);
        bookingDto.setBookingDate(java.time.LocalDate.now());
        bookingDto.setNumberOfGuests(2);
        bookingDto.setSpecialRequests("Late Check-In");
        bookingDto.setUserId(101); // Assuming a valid user ID
        bookingDto.setHotelId(501); // Assuming a valid hotel ID
        bookingDto.setRoomId(301); // Assuming a valid room ID

        // Call the service method
        Bookings booking = service.createBooking(bookingDto);

        // Validate the result
        assertNotNull(booking);
        assertEquals(1, booking.getBookingId()); // Optional: Replace with the expected booking ID
    }

    @Test
    @Disabled
    void testGetBookingById() {
        // Assuming booking ID 1 exists in the database
        Bookings booking = service.getBookingById(1);

        assertNotNull(booking);
        assertEquals(1, booking.getBookingId());
    }

    @Test
    @Disabled
    void testCancelBookingById() {
        // Cancel booking with ID 1
        service.cancelBookingById(1);

        // Verify the status of the booking
        Bookings cancelledBooking = service.getBookingById(1);
        assertEquals(Bookings.BookingStatus.CANCELLED, cancelledBooking.getBookingStatus());
    }
    
    @Test
    @Disabled
    void testGetBookingsByStatus() {
        // Call the service to get bookings by status
        BookingStatus status = BookingStatus.PENDING; // Use a valid status that exists in your DB
        List<Bookings> bookings = service.getBookingsByStatus(status);

        // Validate the result
        assertNotNull(bookings, "The list of bookings should not be null");
        assertEquals(status, bookings.get(0).getBookingStatus(), "The booking status should match the requested status");
        System.out.println("Bookings retrieved: " + bookings);
    }
}