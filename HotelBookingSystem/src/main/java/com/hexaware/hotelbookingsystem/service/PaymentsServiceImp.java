/*
 *service class implementation  for payments
 *Author : Prerna
 *Date: 2024-11-22
 * */
package com.hexaware.hotelbookingsystem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotelbookingsystem.dto.PaymentsDto;
import com.hexaware.hotelbookingsystem.entities.Bookings;
import com.hexaware.hotelbookingsystem.entities.Hotels;
import com.hexaware.hotelbookingsystem.entities.Payments;
import com.hexaware.hotelbookingsystem.entities.Users;
import com.hexaware.hotelbookingsystem.entities.Payments.PaymentMethod;
import com.hexaware.hotelbookingsystem.repository.BookingsRepository;
import com.hexaware.hotelbookingsystem.repository.PaymentsRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class PaymentsServiceImp implements IPaymentsService {

	
	@Autowired
	IBookingsService service;
	@Autowired
    private BookingsRepository bookingsRepository;
	@Autowired
	private PaymentsRepository repo;

	// 1. Process a new payment
	public Payments processPayment(PaymentsDto paymentDto) {
		 System.out.println("Payment DTO: " + paymentDto);

	        if (paymentDto.getBookingId() == null) {
	            throw new IllegalArgumentException("Booking ID must not be null");
	        }
	        Bookings booking = service.getBookingById(paymentDto.getBookingId());
	        if (booking == null) {
	            throw new RuntimeException("No booking found with ID: " + paymentDto.getBookingId());
	        }
		Payments payment = new Payments();
        payment.setPaymentAmount(paymentDto.getPaymentAmount());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        
        payment.setTransactionId(paymentDto.getTransactionId());
        payment.setRemarks(paymentDto.getRemarks());
        
     // Fetch the associated hotel through the booking and set it
        payment.setHotel(booking.getHotel());
        payment.setPaymentMethod(Payments.PaymentMethod.valueOf(paymentDto.getPaymentMethod().name()));
        payment.setPaymentStatus(Payments.PaymentStatus.valueOf(paymentDto.getPaymentStatus().name()));
        payment.setCreatedAt(paymentDto.getPaymentDate());
        // Fetch the user from the booking, as it's related to the payment
        Users user = booking.getUser();  // Get user from booking (assuming the booking has a user)
        payment.setUser(user);
    /*    if (paymentDto.getBookingId() != null) {
            Bookings booking = bookingsService.getBookingById(paymentDto.getBookingId());
            payment.setBooking(booking);
        }
    */
      /*  Hotels hotel=service.getHotelById(reviewsDto.getHotelId());
		reviews.setHotel(hotel);
	    // Set 'createdAt' to the current time
	    reviews.setCreatedAt(reviewsDto.getCreatedAt()); 
	    
	    */
        
      
     // Fetch the booking by bookingId and set it in the payment
       
        payment.setBooking(booking); // Set the booking entity in the payment
        return repo.save(payment);
	}
	
	// 2. Get payment by ID
	@Override
	public Payments getPaymentById(Integer paymentId) {
		return repo.findById(paymentId).orElse(null); // Retrieve payment or return null
	}

	
/*
	// 3. Update payment status
	@Override
	public Payments updatePaymentStatus(Payments payment) {
		Optional<Payments> existingPayment = repo.findById(payment.getPaymentId());
		if (existingPayment.isPresent()) {
			Payments updatedPayment = existingPayment.get();
			updatedPayment.setPaymentStatus(payment.getPaymentStatus());
			return repo.save(updatedPayment);
		}
		return null; // Return null if payment not found
	}
*/
	@Override
	public Payments updatePayment(Payments payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payments> getAllPayments() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deletePaymentById(Integer paymentId) {
	repo.deleteById(paymentId);
		
	}

	
}