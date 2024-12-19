package com.hexaware.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.hexaware.staff.dto.Hotels;
import com.hexaware.staff.dto.StaffsDto;
import com.hexaware.staff.dto.StaffsHotelsVO;
import com.hexaware.staff.entity.Staffs;
import com.hexaware.staff.repository.StaffRepository;
@Service
public class StaffsServiceImp implements IStaffsService{
	
	@Autowired
	StaffRepository repo;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Staffs addStaff(StaffsDto staffsDto) {
		
		Staffs staff = new Staffs();
		staff.setStaffId(staffsDto.getStaffId());
		staff.setName(staffsDto.getName());
		staff.setContactInfo(staffsDto.getContactInfo());
		staff.setShiftTiming(staffsDto.getShiftTiming());
		staff.setHotelId(staffsDto.getHotelId());
		
		return repo.save(staff);
	}

	@Override
	public StaffsDto getStaffById(Integer staffId) {
		
		Staffs staff = repo.findById(staffId).orElse(null);


		StaffsDto dto = new StaffsDto();
		
		dto.setStaffId(staff.getStaffId());
		dto.setName(staff.getName());
		dto.setContactInfo(staff.getContactInfo());
		dto.setShiftTiming(staff.getShiftTiming());
		dto.setHotelId(staff.getHotelId());
		return dto;
	}

	@Override
	public List<Staffs> getAllStaffs() {
		
		return  repo.findAll();
	}

	@Override
	public StaffsHotelsVO getStaffAndHotelById(Integer staffId) {
		StaffsDto staff = getStaffById(staffId);
		
		int hotelId = staff.getHotelId();

		// step2 call rest api from product microservice int pid
		// =customer.getProductId();
		// Product // http://localhost:8282/api/products/get/{pid}

		Hotels hotel = restTemplate.getForObject("http://localhost:8080/api/hotels/getbyid/" + hotelId, Hotels.class);

		StaffsHotelsVO staffsHotelsVO = new StaffsHotelsVO();

		staffsHotelsVO.setStaffDto(staff);
		staffsHotelsVO.setHotel(hotel);

		return staffsHotelsVO;
	}

	@Override
	public void updateHotelsByStaffs(Hotels hotel) {
		
		restTemplate.put("http://localhost:8080/api/hotels/update", hotel);
		System.out.println("updated hotels from staffs  " );
	}

}

