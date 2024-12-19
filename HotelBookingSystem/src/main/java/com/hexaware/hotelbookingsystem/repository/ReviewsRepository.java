
package com.hexaware.hotelbookingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.hotelbookingsystem.entities.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {

	List<Reviews> findByHotel_HotelId(Integer hotelId);

	List<Reviews> findByUser_UserId(Integer userId);

// Calculate the average rating for a specific hotel
    @Query("SELECT AVG(r.rating) FROM Reviews r WHERE r.hotel.id = :hotelId")
    Double getAverageRatingByHotelId(@Param("hotelId") Integer hotelId);
 	
	
}