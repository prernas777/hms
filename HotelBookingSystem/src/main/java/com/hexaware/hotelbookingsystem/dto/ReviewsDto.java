/*
 *Dto class For Reviews
 *Author : Prerna
 *Date: 2024-11-21
 * */
package com.hexaware.hotelbookingsystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;



public class ReviewsDto {

    private Integer reviewId;
    private Integer rating;
    private String reviewTitle;
    private String comments;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Integer userId;
    private Integer hotelId;
    
   
    public ReviewsDto(Integer reviewId, Integer rating, String reviewTitle, String comments, LocalDate createdAt,
			LocalDate updatedAt, Integer userId, Integer hotelId) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.reviewTitle = reviewTitle;
		this.comments = comments;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userId = userId;
		this.hotelId = hotelId;
	}

	// Getters and Setters
    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }
}