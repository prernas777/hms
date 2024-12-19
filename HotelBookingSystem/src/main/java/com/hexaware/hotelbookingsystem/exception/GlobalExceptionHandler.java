package com.hexaware.hotelbookingsystem.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException() {
	    return new ResponseEntity<>("Invalid input format please enter valid userId  ",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<String> handleHotelNotFoundException() {
	    return new ResponseEntity<>("Invalid input format please enter valid hotelId  ",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(RoomNotFoundException.class)
	public ResponseEntity<String> handleRoomNotFoundException() {
	    return new ResponseEntity<>("Invalid input format please enter valid roomId  ",HttpStatus.BAD_REQUEST);
	}
	
	 @ExceptionHandler(PaymentNotFoundException.class)
	    public ResponseEntity<Map<String, Object>> handlePaymentNotFoundException(PaymentNotFoundException ex) {
	        Map<String, Object> errorDetails = new HashMap<>();
	        errorDetails.put("timestamp", LocalDateTime.now());
	        errorDetails.put("message", ex.getMessage());
	        errorDetails.put("status", HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

	    // Handle BookingNotFoundException
	    @ExceptionHandler(BookingNotFoundException.class)
	    public ResponseEntity<Map<String, Object>> handleBookingNotFoundException(BookingNotFoundException ex) {
	        Map<String, Object> errorDetails = new HashMap<>();
	        errorDetails.put("timestamp", LocalDateTime.now());
	        errorDetails.put("message", ex.getMessage());
	        errorDetails.put("status", HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

	    // Handle ReviewNotFoundException
	    @ExceptionHandler(ReviewNotFoundException.class)
	    public ResponseEntity<Map<String, Object>> handleReviewNotFoundException(ReviewNotFoundException ex) {
	        Map<String, Object> errorDetails = new HashMap<>();
	        errorDetails.put("timestamp", LocalDateTime.now());
	        errorDetails.put("message", ex.getMessage());
	        errorDetails.put("status", HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }


}
