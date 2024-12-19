
/*
 *Entity class for rooms
 *Author : Ganga
 *Date   : 2024-11-07
 * */
package com.hexaware.hotelbookingsystem.entities;
	import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

	@Entity
	public class Rooms {
			@Id
			private Integer roomId;
	         
			@Column(unique = true)
		    private Integer roomNumber; 
			
			@Enumerated(EnumType.STRING)
			private RoomType roomType; 
			
			private Double pricePerNight;   
			
			@Enumerated(EnumType.STRING)
			private AvailabilityStatus availabilityStatus; 
			
			private Integer capacity;           
			private String description;
			
		
			@ManyToOne(cascade = CascadeType.MERGE ,  fetch = FetchType.LAZY)
			@JsonManagedReference
		    @JoinColumn(name = "hotel_id")
		    private Hotels hotel; 

		    @OneToMany(mappedBy = "room")
		    @JsonBackReference
		    private List<Bookings> bookings; 
		    
		    @ManyToMany( cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
		    @JsonIgnore
		    @JoinTable(
		        name = "user_favorite_rooms", 
		        joinColumns = @JoinColumn(name = "room_id"), 
		        inverseJoinColumns = @JoinColumn(name = "user_id")  
		    )
		    
		    private List<Users> users;
		    
			public enum RoomType {
				SINGLE, DOUBLE, SUITE
			}
			
			public enum AvailabilityStatus {
				AVAILABLE, BOOKED
			}
			public Rooms() {
				super();
			}
		
			public Rooms(Integer roomId, Integer roomNumber, RoomType roomType, Double pricePerNight,
					AvailabilityStatus availabilityStatus, Integer capacity, String description) {
				super();
				this.roomId = roomId;
				this.roomNumber = roomNumber;
				this.roomType = roomType;
				this.pricePerNight = pricePerNight;
				this.availabilityStatus = availabilityStatus;
				this.capacity = capacity;
				this.description = description;
			}

			public Integer getRoomId() {
				return roomId;
			}

			public void setRoomId(Integer roomId) {
				this.roomId = roomId;
			}

			public Integer getRoomNumber() {
				return roomNumber;
			}

			public void setRoomNumber(Integer roomNumber) {
				this.roomNumber = roomNumber;
			}

			public RoomType getRoomType() {
				return roomType;
			}

			public void setRoomType(RoomType roomType) {
				this.roomType = roomType;
			}

			public Double getPricePerNight() {
				return pricePerNight;
			}

			public void setPricePerNight(Double pricePerNight) {
				this.pricePerNight = pricePerNight;
			}

			public AvailabilityStatus getAvailabilityStatus() {
				return availabilityStatus;
			}

			public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
				this.availabilityStatus = availabilityStatus;
			}

			public Integer getCapacity() {
				return capacity;
			}

			public void setCapacity(Integer capacity) {
				this.capacity = capacity;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
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

			public List<Users> getUsers() {
				return users;
			}

			public void setUsers(List<Users> users) {
				this.users = users;
			}

}
