/*
 *service class implementation  for bookings
 *Author : Prerna
 *Date: 2024-11-22
 * */
package com.hexaware.hotelbookingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import com.hexaware.hotelbookingsystem.dto.BookingsDto;
import com.hexaware.hotelbookingsystem.entities.Bookings;
import com.hexaware.hotelbookingsystem.entities.Users;
import com.hexaware.hotelbookingsystem.entities.Hotels;
import com.hexaware.hotelbookingsystem.entities.Rooms;
import com.hexaware.hotelbookingsystem.entities.Bookings.BookingStatus;
import com.hexaware.hotelbookingsystem.repository.BookingsRepository;
import com.hexaware.hotelbookingsystem.repository.UsersRepository;
import com.hexaware.hotelbookingsystem.repository.HotelsRepository;
import com.hexaware.hotelbookingsystem.repository.RoomsRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BookingsServiceImp implements IBookingsService {

    @Autowired
    private BookingsRepository repo;

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private HotelsRepository hotelRepository;

    @Autowired
    private RoomsRepository roomRepository;

    @Override
    public Bookings createBooking(BookingsDto bookingDto) {
        // Create a new Bookings entity
        Bookings booking = new Bookings();

        // Set properties from BookingsDto
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());
        booking.setTotalAmount(bookingDto.getTotalAmount());
     /*
        // Handle null check for booking status
        if (bookingDto.getBookingStatus() != null) {
            booking.setBookingStatus(BookingStatus.valueOf(bookingDto.getBookingStatus().toUpperCase()));
        } else {
            // Set default status to PENDING if not provided
            booking.setBookingStatus(BookingStatus.PENDING);
        }
        */

        booking.setBookingStatus(Bookings.BookingStatus.valueOf(bookingDto.getBookingStatus().name()));

        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setNumberOfGuests(bookingDto.getNumberOfGuests());
        booking.setSpecialRequests(bookingDto.getSpecialRequests());


        Users user = new Users();
        user.setUserId(bookingDto.getUserId());  // Set the user ID
        booking.setUser(user);

        Hotels hotel = new Hotels();
        hotel.setHotelId(bookingDto.getHotelId());  // Set the hotel ID
        booking.setHotel(hotel);

        Rooms room = new Rooms();
        room.setRoomId(bookingDto.getRoomId());  // Set the room ID
        booking.setRoom(room);

        // Save the booking and return the saved entity
        return repo.save(booking);
    }



    @Override
    public Bookings getBookingById(Integer bookingId) {
        if (bookingId == null) {
            throw new IllegalArgumentException("Booking ID cannot be null");
        }
        return repo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("No booking found with ID: " + bookingId));
    }


   /*

    @Override
    public Bookings updateBooking(BookingsDto bookingDto) {
        Optional<Bookings> optionalBooking = repo.findById(bookingDto.getBookingId());
        if (optionalBooking.isPresent()) {
            // Fetch the existing booking entity
            Bookings booking = optionalBooking.get();

            // Update the booking details with the new data from the DTO
            booking.setCheckInDate(bookingDto.getCheckInDate());
            booking.setCheckOutDate(bookingDto.getCheckOutDate());
            booking.setTotalAmount(bookingDto.getTotalAmount());
            booking.setBookingStatus(BookingStatus.valueOf(bookingDto.getBookingStatus().toUpperCase()));
            booking.setBookingDate(bookingDto.getBookingDate());
            booking.setNumberOfGuests(bookingDto.getNumberOfGuests());
            booking.setSpecialRequests(bookingDto.getSpecialRequests());


            // Save and return the updated booking
            return repo.save(booking);
        }
        throw new RuntimeException("Booking not found with ID: " + bookingDto.getBookingId());
    }
    */

    @Override
    public void cancelBookingById(Integer bookingId) {
        Optional<Bookings> optionalBooking = repo.findById(bookingId);
        optionalBooking.ifPresent(booking -> {
            booking.setBookingStatus(BookingStatus.CANCELLED);
            repo.save(booking);
        });
    }

    @Override
    public List<Bookings> getBookingsByStatus(BookingStatus status) {
        return repo.findByBookingStatus(status);
    }

  @Override
  public List<Bookings> getAllBookings() {

    return repo.findAll();
  }
}
