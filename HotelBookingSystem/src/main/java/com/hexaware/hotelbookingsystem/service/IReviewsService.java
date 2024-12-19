/*
 *Interface  for Reviews
 *Author : Prerna
 *Date: 2024-11-15
 * */package com.hexaware.hotelbookingsystem.service;

import java.util.List;

import com.hexaware.hotelbookingsystem.dto.ReviewsDto;
import com.hexaware.hotelbookingsystem.entities.Reviews;

public interface IReviewsService {

	// Adds a new review
	Reviews addReview(ReviewsDto reviewsDto);

	// Retrieves a review by its ID
	Reviews getReviewById(Integer reviewId);

	
	// Updates a review based on review ID (returns the updated review)
	//Reviews updateReview(ReviewsDto reviewDto);

	// Deletes a review by ID
	void deleteReviewById(Integer reviewId);

	Double getAverageRatingByHotelId(Integer hotelId);

}