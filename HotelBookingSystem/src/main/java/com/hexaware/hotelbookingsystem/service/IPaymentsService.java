/*
 *Interface  for payments
 *Author : Prerna
 *Date: 2024-11-15
 * */
package com.hexaware.hotelbookingsystem.service;

import java.util.List;

import com.hexaware.hotelbookingsystem.dto.PaymentsDto;
import com.hexaware.hotelbookingsystem.entities.Payments;

public interface IPaymentsService {

	// Processes a new payment
	Payments processPayment(PaymentsDto paymentDto);

	// Retrieves a payment by its ID
	Payments getPaymentById(Integer paymentId);

	// Updates the status of a payment
	Payments updatePayment(Payments payment);
	
	// Retrieves all payments (optional for admin views or reporting)
    List<Payments> getAllPayments();

    // Deletes a payment by its ID
    void deletePaymentById(Integer paymentId);

}