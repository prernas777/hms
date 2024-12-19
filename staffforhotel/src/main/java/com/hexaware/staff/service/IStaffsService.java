package com.hexaware.staff.service;

import java.util.List;

import com.hexaware.staff.dto.Hotels;
import com.hexaware.staff.dto.StaffsDto;
import com.hexaware.staff.dto.StaffsHotelsVO;
import com.hexaware.staff.entity.Staffs;



public interface IStaffsService {
	
    public Staffs	addStaff(StaffsDto staffsDto);
	
	public StaffsDto	getStaffById(Integer staffId);
		
	public List<Staffs>	getAllStaffs();
	
	public   StaffsHotelsVO   getStaffAndHotelById(Integer staffId);

	public void updateHotelsByStaffs(Hotels hotel);

}
