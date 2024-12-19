/*
 *Controller  for Reviews
 *Author : Prerna
 *Date: 2024-11-16
 * */
package com.hexaware.hotelbookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hotelbookingsystem.dto.ReviewsDto;
import com.hexaware.hotelbookingsystem.entities.Reviews;
import com.hexaware.hotelbookingsystem.exception.ReviewNotFoundException;
import com.hexaware.hotelbookingsystem.service.IReviewsService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

    @Autowired
    IReviewsService service;

    @PostMapping("/add")
    public Reviews addReview(@RequestBody ReviewsDto reviewsDto) {
        return service.addReview(reviewsDto);
    }
/*
    @PutMapping("/update/{reviewId}")
    public Reviews updateReview(@PathVariable Integer reviewId, @RequestBody Reviews updatedReview) {
        updatedReview.setReviewId(reviewId); // Ensure the ID remains unchanged
        return service.updateReview(updatedReview);
    }
*/
    @DeleteMapping("/delete/{reviewId}")
    public String deleteReview(@PathVariable Integer reviewId) {
        service.deleteReviewById(reviewId);
        return "Review with ID " + reviewId + " deleted.";
    }

    @GetMapping("/getbyid/{reviewId}")
    public Reviews getReviewById(@PathVariable Integer reviewId) {
        Reviews review = service.getReviewById(reviewId);
        if (review == null) {
            throw new ReviewNotFoundException("Review not found for ID: " + reviewId);
        }
        return review;
    }


    @GetMapping("/average-rating/{hotelId}")
    public Double getAverageRatingByHotelId(@PathVariable Integer hotelId) {
        return service.getAverageRatingByHotelId(hotelId);
    }
}