package com.hexaware.hotelbookingsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.hotelbookingsystem.entities.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Integer> {
	List<Payments> findByUser_UserId(Integer userId);

	List<Payments> findByBooking_BookingId(Integer bookingId);
	
	// Update payment status (custom query if required)
    @Query("SELECT p FROM Payments p WHERE p.paymentId = :paymentId")
    Optional<Payments> findPaymentById(@Param("paymentId") Integer paymentId);

}