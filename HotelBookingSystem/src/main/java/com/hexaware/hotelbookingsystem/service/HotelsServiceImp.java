/*
 *service class implementation  for hotels
 *Author : Ganga
 *Date: 2024-11-22
 * */
package com.hexaware.hotelbookingsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotelbookingsystem.dto.HotelsDto;
import com.hexaware.hotelbookingsystem.entities.Hotels;
import com.hexaware.hotelbookingsystem.entities.Users;
import com.hexaware.hotelbookingsystem.repository.HotelsRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class HotelsServiceImp implements IHotelsService {
	
	@Autowired 
	HotelsRepository repo;
	
	@Autowired
	IUsersService service;
	
	Logger logger=LoggerFactory.getLogger(HotelsServiceImp.class);

	@Override
	public Hotels addHotels(HotelsDto hotelDto) {
		Hotels hotel=new Hotels();
		
		hotel.setHotelId(hotelDto.getHotelId());
		hotel.setHotelName(hotelDto.getHotelName());
		hotel.setAddress(hotelDto.getAddress());
		hotel.setCity(hotelDto.getCity());
		hotel.setDescription(hotelDto.getDescription());
		hotel.setContactNumber(hotelDto.getContactNumber());
		hotel.setRating(hotelDto.getRating());
		 Users user = service.getUsersById(hotelDto.getUserId());  
		    
		   
		    hotel.setUser(user);
		    logger.info("Hotels add service is called");
		return repo.save(hotel);
	}

	@Override
	public Hotels updateHotels(HotelsDto hotelDto) {
		
	Hotels hotel=new Hotels();
		
		hotel.setHotelId(hotelDto.getHotelId());
		hotel.setHotelName(hotelDto.getHotelName());
		hotel.setAddress(hotelDto.getAddress());
		hotel.setCity(hotelDto.getCity());
		hotel.setDescription(hotelDto.getDescription());
		hotel.setContactNumber(hotelDto.getContactNumber());
		hotel.setRating(hotelDto.getRating());
		//hotel.setUser(hotelDto.getUserId());
		logger.info("Hotels update service is called");
		return repo.save(hotel);
	}

	@Override
	public Hotels getHotelById(Integer hotelId) {
		
		return repo.findById(hotelId).orElse(null);
	}

	@Override
	public void deleteHotelsById(Integer hotelId) {
		
		repo.deleteById(hotelId);
		
	}

	@Override
	public List<Hotels> getAllHotels() {
		
		return  repo.findAll();
	}

	@Override
	public List<Hotels> getByCity(String city) {
		
		return repo.findByCity(city);
	}

	@Override
	public List<Hotels> getByRating(Double rating) {
		
		return repo.findByRating(rating);
	}



}
