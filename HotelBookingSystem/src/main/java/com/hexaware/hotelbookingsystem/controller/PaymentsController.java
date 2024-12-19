/*
 *Controller  for payments
 *Author : Prerna
 *Date: 2024-11-16
 * */
package com.hexaware.hotelbookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hotelbookingsystem.dto.PaymentsDto;
import com.hexaware.hotelbookingsystem.entities.Payments;
import com.hexaware.hotelbookingsystem.entities.Reviews;
import com.hexaware.hotelbookingsystem.exception.PaymentNotFoundException;
import com.hexaware.hotelbookingsystem.exception.ReviewNotFoundException;
import com.hexaware.hotelbookingsystem.service.IPaymentsService;

@RestController
@RequestMapping("/api/payments")
public class PaymentsController {

    @Autowired
    IPaymentsService service;

    @PostMapping("/process")
    public Payments processPayment(@RequestBody PaymentsDto paymentdto) {
		return service.processPayment(paymentdto);
    }

  

    @GetMapping("/getbyid/{paymentId}")
    public Payments getPaymentById(@PathVariable Integer paymentId) {
        Payments payment = service.getPaymentById(paymentId);
        if (payment == null) {
            throw new PaymentNotFoundException("Payment not found for ID: " + paymentId);
        }
        return payment;
    }
    
/*
    @GetMapping("/getbyuserid/{userId}")
    public List<Payments> getPaymentsByUserId(@PathVariable Integer userId) {
        return service.getPaymentsByUserId(userId);
    }

    @GetMapping("/getbybookingid/{bookingId}")
    public List<Payments> getPaymentsByBookingId(@PathVariable Integer bookingId) {
        return service.getPaymentsByBookingId(bookingId);
    }
 */
/*
    @PutMapping("/updateStatus/{paymentId}")
    public Payments updatePaymentStatus(@PathVariable Integer paymentId, @RequestBody Payments updatedPayment) {
        updatedPayment.setPaymentId(paymentId); // Ensure the ID remains unchanged
        return service.updatePaymentStatus(updatedPayment);
    }
    */
}