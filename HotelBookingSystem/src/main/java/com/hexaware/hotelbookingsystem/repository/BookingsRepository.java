package com.hexaware.hotelbookingsystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.hotelbookingsystem.entities.Bookings;
import com.hexaware.hotelbookingsystem.entities.Bookings.BookingStatus;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer> {

    // Fetch bookings by user ID
/*	@Query("SELECT b FROM Bookings b WHERE b.hotel.hotelId = :hotelId")
    List<Bookings> findByHotelId(@Param("hotelId") Integer hotelId);
*/
    // Fetch bookings for a specific hotel
    List<Bookings> findByHotel_HotelId(Integer hotelId);

    List<Bookings> findByBookingStatus(BookingStatus status);

    List<Bookings> findByRoom_RoomId(Integer roomId);

    List<Bookings> findByBookingDateBetween(LocalDate startDate, LocalDate endDate);
    
 // Fetch bookings by user ID
    List<Bookings> findByUser_UserId(Integer userId);
    
   }