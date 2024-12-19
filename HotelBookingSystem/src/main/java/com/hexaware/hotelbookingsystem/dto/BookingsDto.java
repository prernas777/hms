/*
 *Dto class For Bookings
 *Author : Prerna
 *Date: 2024-11-21
 * */
package com.hexaware.hotelbookingsystem.dto;

import java.time.LocalDate;



public class BookingsDto {

    private Integer bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Double totalAmount;
   
    private BookingStatus bookingStatus;
    private LocalDate bookingDate;
    private Integer numberOfGuests;
    private String specialRequests;
    private Integer userId; // Only the ID for the associated user
    private Integer hotelId; // Only the ID for the associated hotel
    private Integer roomId; // Only the ID for the associated room

    public enum BookingStatus {
        CONFIRMED, CANCELLED, PENDING;

		public String toUpperCase() {
			// TODO Auto-generated method stub
			return null;
		}
    }

    // Parameterized Constructor
    public BookingsDto(Integer bookingId, LocalDate checkInDate, LocalDate checkOutDate, Double totalAmount,
                       BookingStatus bookingStatus, LocalDate bookingDate, Integer numberOfGuests,
                       String specialRequests, Integer userId, Integer hotelId, Integer roomId) {
        super();
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
        this.bookingDate = bookingDate;
        this.numberOfGuests = numberOfGuests;
        this.specialRequests = specialRequests;
        this.userId = userId;
        this.hotelId = hotelId;
        this.roomId = roomId;
    }

    // Default Constructor
    public BookingsDto() {
        super();
    }

    // Getters and Setters
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}