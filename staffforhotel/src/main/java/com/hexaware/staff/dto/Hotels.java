package com.hexaware.staff.dto;

public class Hotels {
	
	private Integer hotelId;
	private String hotelName;
	 private String address; 
	 private String city;
	 private String description;
	 private Long contactNumber;
	 private Double rating;
	 
	 
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

	

}
