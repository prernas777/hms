/*
 *service class implementation  for reviews
 *Author : Prerna
 *Date: 2024-11-22
 * */
package com.hexaware.hotelbookingsystem.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotelbookingsystem.dto.ReviewsDto;
import com.hexaware.hotelbookingsystem.entities.Hotels;
import com.hexaware.hotelbookingsystem.entities.Reviews;
import com.hexaware.hotelbookingsystem.entities.Users;
import com.hexaware.hotelbookingsystem.repository.ReviewsRepository;

@Service
public class ReviewsServiceImp implements IReviewsService {
    
	@Autowired
	IHotelsService service;
	@Autowired
	private IUsersService serviceUsers ;
	@Autowired
	private ReviewsRepository repo;

	// 1. Add a new review
	@Override
	public Reviews addReview(ReviewsDto reviewsDto) {
		
	    
		Reviews reviews=new Reviews();
	    // Set the required fields
	    reviews.setReviewId(reviewsDto.getReviewId());
	    reviews.setComments(reviewsDto.getComments());
	    reviews.setRating(reviewsDto.getRating());
	    reviews.setReviewTitle(reviewsDto.getReviewTitle());
	     // Assuming you have a way to set the hotel entity

	    Hotels hotel=service.getHotelById(reviewsDto.getHotelId());
		reviews.setHotel(hotel);
	    // Set 'createdAt' to the current time
	    reviews.setCreatedAt(reviewsDto.getCreatedAt()); 
		
		
		Users user=serviceUsers.getUsersById(reviewsDto.getUserId());
		reviews.setUser(user);
	    // Set 'createdAt' to the current time
	    reviews.setCreatedAt(reviewsDto.getCreatedAt()); 
		return repo.save(reviews);
	}


	
	
	// 2. Get review by ID
	@Override
	public Reviews getReviewById(Integer reviewId) {
		
		
		
		return repo.findById(reviewId).orElse(null); // Retrieve review or return null
	}

	/*

	// 5. Update an existing review
	@Override
	public Reviews updateReview(Reviews review) {
		
		Reviews reviews=new Reviews();
	    // Set the required fields
	    reviews.setReviewId(reviewsDto.getReviewId());
	    reviews.setComments(reviewsDto.getComments());
	    reviews.setRating(reviewsDto.getRating());
	    reviews.setReviewTitle(reviewsDto.getReviewTitle());
	     // Assuming you have a way to set the hotel entity

	    Hotels hotel=service.getHotelById(reviewsDto.getHotelId());
		reviews.setHotel(hotel);
	    // Set 'createdAt' to the current time
	    reviews.setCreatedAt(reviewsDto.getCreatedAt()); 
		
		
		Users user=serviceUsers.getUsersById(reviewsDto.getUserId());
		reviews.setUser(user);
	    // Set 'createdAt' to the current time
	    reviews.setCreatedAt(reviewsDto.getCreatedAt()); 
		
			return repo.save(review); // Update the review
		
	}
	*/

	// 6. Delete a review by ID
	@Override
	public void deleteReviewById(Integer reviewId) {
		repo.deleteById(reviewId); // Delete review by ID
	}

	// 7. Get the average rating for a specific hotel
	@Override
	public Double getAverageRatingByHotelId(Integer hotelId) {
		return repo.getAverageRatingByHotelId(hotelId); // Retrieve average rating
	}



	
}