/*
 *Dto class For payments
 *Author : Prerna
 *Date: 2024-11-21
 * */
package com.hexaware.hotelbookingsystem.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaymentsDto {

    private Integer paymentId; // Unique ID for the payment
    private Double paymentAmount; // Amount paid
    private LocalDate paymentDate; // Date and time of payment
    private PaymentMethod paymentMethod; // Method used for payment
    private PaymentStatus paymentStatus; // Current status of the payment
    private String transactionId; // Transaction reference ID
    private String remarks; // Optional remarks or notes
    private Integer bookingId;
    public enum PaymentMethod {
        CREDIT_CARD, DEBIT_CARD, NET_BANKING, UPI, CASH
    }

    public enum PaymentStatus {
        SUCCESS, FAILED, PENDING, REFUNDED
    }

    // Parameterized Constructor
    public PaymentsDto(Integer paymentId, Double paymentAmount, LocalDate paymentDate,PaymentMethod paymentMethod,
    		PaymentStatus paymentStatus, String transactionId, String remarks) {
        super();
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.transactionId = transactionId;
        this.remarks = remarks;
    }

    // Default Constructor
    public PaymentsDto() {
        super();
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

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
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
	
	public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }
}