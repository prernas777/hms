/*
 *Interface  for Hotels
 *Author : Ganga
 *Date: 2024-11-15
 * */
package com.hexaware.hotelbookingsystem.service;

import java.util.List;

import com.hexaware.hotelbookingsystem.dto.HotelsDto;
import com.hexaware.hotelbookingsystem.entities.Hotels;

public interface IHotelsService {
	
		public Hotels addHotels(HotelsDto hotelDto);
		
		public Hotels updateHotels(HotelsDto hotelDto);
		
		public Hotels getHotelById(Integer hotelId);
		
		public void deleteHotelsById(Integer hotelId);
		
		public List<Hotels> getAllHotels();
		
		public List<Hotels> getByCity(String city);
		
		public List<Hotels> getByRating(Double rating);
		
	

}
