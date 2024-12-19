/*
 *Entity class for hotels
 *Author :Ganga
 *Date: 2024-11-07
 * */package com.hexaware.hotelbookingsystem.entities;
	import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


	@Entity
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "hotelId")
	public class Hotels {
		
		@Id
		private Integer hotelId; 
		
		@Pattern(regexp="^[a-zA-Z]{2,50}$", message="Name should only contain letters and be 2 to 50 characters long")
		 private String hotelName;
		       
		 private String address; 
		 
		 @NotBlank(message = "City is required")
		 private String city;  
		 
		 @Size(max = 500, message = "Description must not exceed 500 characters")
		 private String description;
		 
		 @Pattern(regexp="^[0-9]{10}$", message="Phone number must be exactly 10 digits")
		 private Long contactNumber;
		 
		 @NotNull(message = "Rating is required")
		 @DecimalMin(value = "0.0", message = "Rating must be at least 0.0")
		 @DecimalMax(value = "5.0", message = "Rating must be at most 5.0")
		 private Double rating;
		 
		 @OneToOne
		 @JoinColumn(name = "user_id") 
		 @JsonManagedReference
		 private Users user;
		 
		
		 @OneToMany(mappedBy = "hotel", cascade = CascadeType.MERGE ,  fetch = FetchType.LAZY)
		 @JsonBackReference
		 private List<Rooms> rooms; 

		 
		 @OneToMany(mappedBy = "hotel" , cascade = CascadeType.MERGE ,  fetch = FetchType.LAZY)
		 @JsonBackReference
		 private List<Reviews> reviews;
		    
		 @OneToMany(mappedBy = "hotel", cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
		 @JsonBackReference
		 private List<Bookings> bookings; 

		 
		 @OneToMany(mappedBy = "hotel", cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
		 @JsonBackReference
		 private List<Payments> payments; 
		 
		public Hotels() {
			super();
		}
		

		public Hotels(Integer hotelId, String hotelName, String address, String city, String description,
				Long contactNumber, Double rating) {
			super();
			this.hotelId = hotelId;
			this.hotelName = hotelName;
			this.address = address;
			this.city = city;
			this.description = description;
			this.contactNumber = contactNumber;
			this.rating = rating;
		}


		public Integer getHotelId() {
			return hotelId;
		}


		public void setHotelId(Integer hotelId) {
			this.hotelId = hotelId;
		}


		public String getHotelName() {
			return hotelName;
		}


		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public Long getContactNumber() {
			return contactNumber;
		}


		public void setContactNumber(Long contactNumber) {
			this.contactNumber = contactNumber;
		}


		public Double getRating() {
			return rating;
		}


		public void setRating(Double rating) {
			this.rating = rating;
		}


		public Users getUser() {
			return user;
		}


		public void setUser(Users user) {
			this.user = user;
		}


		public List<Rooms> getRooms() {
			return rooms;
		}


		public void setRooms(List<Rooms> rooms) {
			this.rooms = rooms;
		}


		public List<Reviews> getReviews() {
			return reviews;
		}


		public void setReviews(List<Reviews> reviews) {
			this.reviews = reviews;
		}


		public List<Bookings> getBookings() {
			return bookings;
		}


		public void setBookings(List<Bookings> bookings) {
			this.bookings = bookings;
		}


		public List<Payments> getPayments() {
			return payments;
		}


		public void setPayments(List<Payments> payments) {
			this.payments = payments;
		}


		@Override
		public String toString() {
			return "Hotels [hotelId=" + hotelId + ", hotelName=" + hotelName + ", address=" + address + ", city=" + city
					+ ", description=" + description + ", contactNumber=" + contactNumber + ", rating=" + rating + "]";
		}
	


		
		
	

}
