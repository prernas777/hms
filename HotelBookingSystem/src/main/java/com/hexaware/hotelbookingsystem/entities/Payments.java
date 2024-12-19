/*
 *Entity class for payments
 *Author : Prerna
 *Date: 2024-11-07
 * */
package com.hexaware.hotelbookingsystem.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Payments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId; // Primary Key with auto-generation

	@NotNull(message = "Payment amount is mandatory")
	@Column(nullable = false)
	private Double paymentAmount;

	@NotNull(message = "Payment date is mandatory")
	@Column(nullable = false)
	private LocalDate paymentDate;

	@NotNull(message = "Payment method is mandatory")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentMethod paymentMethod;

	@NotNull(message = "Payment status is mandatory")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentStatus paymentStatus;

	private String transactionId; // Optional field, no validation

	private String remarks; // Optional field, no validation

	@NotNull(message = "Created at timestamp is mandatory")
	@Column(nullable = false)
	private LocalDate createdAt;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
	@JsonManagedReference
	private Users user; // Many-to-One relationship with Users

	@ManyToOne
	@JoinColumn(name = "booking_id", referencedColumnName = "bookingId", nullable = false)
	@JsonManagedReference
	private Bookings booking; // Many-to-One relationship with Bookings

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "hotel_id", referencedColumnName = "hotelId", nullable = false) // Ensure correct column mapping
	private Hotels hotel;

	public enum PaymentMethod {

		CREDIT_CARD, DEBIT_CARD, PAYPAL

	}

	public enum PaymentStatus {

		SUCCESS, FAILED, PENDING

	}
	
	
	// Enums for paymentMethod and paymentStatus

	public Users getUser() {
		return user;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate localDate) {
		this.paymentDate = localDate;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public Hotels getHotel() {
		return hotel;
	}

	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Payments() {
		super();
	}

	public Payments(Integer paymentId, Double paymentAmount, LocalDate paymentDate, PaymentMethod paymentMethod,
			PaymentStatus paymentStatus, String transactionId, String remarks, LocalDate createdAt) {
		super();
		this.paymentId = paymentId;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.remarks = remarks;
		this.createdAt = createdAt;
	}

}