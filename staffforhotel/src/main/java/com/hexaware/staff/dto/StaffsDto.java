package com.hexaware.staff.dto;

public class StaffsDto {

	private Integer staffId; 

    private String name;  

    private Long contactInfo; 

    private String shiftTiming; 
    private Integer hotelId;
   
    public StaffsDto() {
    	
    }


	


	public StaffsDto(Integer staffId, String name, Long contactInfo, String shiftTiming, Integer hotelId) {
		super();
		this.staffId = staffId;
		this.name = name;
		this.contactInfo = contactInfo;
		this.shiftTiming = shiftTiming;
		this.hotelId = hotelId;
	}





	public Integer getStaffId() {
		return staffId;
	}


	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(Long contactInfo) {
		this.contactInfo = contactInfo;
	}


	public String getShiftTiming() {
		return shiftTiming;
	}


	public void setShiftTiming(String shiftTiming) {
		this.shiftTiming = shiftTiming;
	}





	public Integer getHotelId() {
		return hotelId;
	}





	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	
}

