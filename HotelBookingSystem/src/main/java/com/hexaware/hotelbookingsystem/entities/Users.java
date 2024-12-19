
/*
 *Entity class for users
 *Author :Ganga
 *Date: 2024-11-07
 * */
package com.hexaware.hotelbookingsystem.entities;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
	@Entity
	public class Users {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private Integer userId;
		
		
		@Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,6}$" , message="enter a valid email")
		private String email;
		
		@NotNull
		private String password;
		
		
		@Pattern(regexp="^[a-zA-Z]{2,50}$", message="Name should only contain letters and be 2 to 50 characters long")
		private String name;
		
		@Pattern(regexp="^[0-9]{10}$", message="Phone number must be exactly 10 digits")
		private Long phoneNumber;
		
		private LocalDate dateCreated;
		
		//@Enumerated(EnumType.STRING)
		private String userRole;
		
		private LocalDate updatedAt;
		
		@OneToOne(mappedBy = "user", cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
		@JsonBackReference
	    private Hotels hotel; 

	    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
		@JsonBackReference
	    private List<Bookings> bookings; 

	    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
		@JsonBackReference
	    private List<Reviews> reviews; 
	    
	    
	    @OneToMany(mappedBy="user", cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
		@JsonBackReference
	    private List<Payments> payments;
	    
//	    public enum UserRole {
//	        GUEST, HOTELOWNER, ADMIN;
//	    }

		public Users() {
			super();
		}

		public Users(Integer userId, String email, String password, String name, Long phoneNumber,
				LocalDate dateCreated, String userRole, LocalDate updatedAt) {
			super();
			this.userId = userId;
			this.email = email;
			this.password = password;
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.dateCreated = dateCreated;
			this.userRole = userRole;
			this.updatedAt = updatedAt;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(Long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public LocalDate getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(LocalDate dateCreated) {
			this.dateCreated = dateCreated;
		}

		public String getUserRole() {
			return userRole;
		}

		public void setUserRole(String role) {
			this.userRole = role;
		}

		public LocalDate getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDate updatedAt) {
			this.updatedAt = updatedAt;
		}

		public Hotels getHotel() {
			return hotel;
		}

		public void setHotel(Hotels hotel) {
			this.hotel = hotel;
		}

		public List<Bookings> getBookings() {
			return bookings;
		}

		public void setBookings(List<Bookings> bookings) {
			this.bookings = bookings;
		}

		public List<Reviews> getReviews() {
			return reviews;
		}

		public void setReviews(List<Reviews> reviews) {
			this.reviews = reviews;
		}

		public List<Payments> getPayments() {
			return payments;
		}

		public void setPayments(List<Payments> payments) {
			this.payments = payments;
		}

		@Override
		public String toString() {
			return "Users [userId=" + userId + ", email=" + email + ", password=" + password + ", name=" + name
					+ ", phoneNumber=" + phoneNumber + ", dateCreated=" + dateCreated + ", userrole=" + userRole
					+ ", updatedAt=" + updatedAt + "]";
		}
		


}
