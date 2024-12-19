package com.hexaware.staff.dto;



public class StaffsHotelsVO {
	
	private  StaffsDto staffDto;
	private  Hotels hotel;
	
	public StaffsHotelsVO() {
		super();
	}

	public StaffsHotelsVO(StaffsDto staffDto, Hotels hotel) {
		super();
		this.staffDto = staffDto;
		this.hotel = hotel;
	}

	public StaffsDto getStaffDto() {
		return staffDto;
	}

	public void setStaffDto(StaffsDto staffDto) {
		this.staffDto = staffDto;
	}

	public Hotels getHotel() {
		return hotel;
	}

	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
	}
	

}
