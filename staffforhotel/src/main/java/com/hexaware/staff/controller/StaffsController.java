package com.hexaware.staff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.staff.dto.Hotels;
import com.hexaware.staff.dto.StaffsDto;
import com.hexaware.staff.dto.StaffsHotelsVO;
import com.hexaware.staff.entity.Staffs;
import com.hexaware.staff.service.IStaffsService;

@RestController
@RequestMapping("/api/staffs")
public class StaffsController {
	@Autowired
	IStaffsService service;
	
	@PostMapping(value="/add", produces = "application/json",consumes = "application/json")
	public Staffs addStaff(@RequestBody StaffsDto staffsDto) {

		return service.addStaff(staffsDto);
	}

	@GetMapping(value="/get/{staffId}" )
	public StaffsDto getStaffById(@PathVariable int staffId) {

		return service.getStaffById(staffId);
	}

	@GetMapping("/getall")
	public List<Staffs> getAllStaff() {

		return service.getAllStaffs();

	}

	@GetMapping("/get/staffs-hotel/{staffId}")
	public StaffsHotelsVO getStaffAndHotelById(@PathVariable int staffId) {

		return service.getStaffAndHotelById(staffId);

	}
	
	
	@PutMapping("/update/hotel-by-staff")
	public String   updateHotelByStaff(@RequestBody Hotels hotel) {
		
		
			 service.updateHotelsByStaffs(hotel);
	
			 return "updated..";
	
	}


}
