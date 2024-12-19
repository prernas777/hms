/*
 *Interface  for bookings
 *Author : Prerna
 *Date: 2024-11-15
 * */
package com.hexaware.hotelbookingsystem.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.hotelbookingsystem.dto.BookingsDto;
import com.hexaware.hotelbookingsystem.entities.Bookings;

public interface IBookingsService {

	// Creates a new booking
	Bookings createBooking(BookingsDto bookingdto);

	// Retrieves a booking by its ID
	Bookings getBookingById(Integer bookingId);

  public List<Bookings> getAllBookings();

/*
	// Retrieves all bookings made by a specific user
	List<Bookings> getBookingsByUserId(Integer userId);

	// Retrieves all bookings for a specific hotel
	List<Bookings> getBookingsByHotelId(Integer hotelId);
*/


	// Updates a booking based on the provided booking object
	//Bookings updateBooking(BookingsDto bookingDto);

	// Cancels a booking by its ID
	void cancelBookingById(Integer bookingId);

	// Retrieves all bookings by status (e.g., Confirmed, Cancelled)
	List<Bookings> getBookingsByStatus(Bookings.BookingStatus status);
/*
	// Retrieves all bookings for a specific room
	List<Bookings> getBookingsByRoomId(Integer roomId);

	List<Bookings> getBookingsByDateRange(LocalDate startDate, LocalDate endDate);
	*/
}
