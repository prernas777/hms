/*
 *Interface  for Rooms
 *Author : Ganga
 *Date: 2024-11-15
 * */package com.hexaware.hotelbookingsystem.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.hotelbookingsystem.dto.RoomsDto;
import com.hexaware.hotelbookingsystem.dto.RoomsDto.RoomType;
import com.hexaware.hotelbookingsystem.entities.Rooms;
import com.hexaware.hotelbookingsystem.entities.Users;

public interface IRoomsService {
	
	 public Rooms addRooms(RoomsDto roomDto);
		
		public Rooms updateRooms(RoomsDto roomDto);
		
		public Rooms getRoomById(Integer roomId);
		
		public void deleteRoomsById(Integer roomId);
		
		public List<Rooms> getAllRooms();
		
		public int updatepricePerNight(Integer pricePerNight, Integer roomId);
		
		public int updateCapacity(Integer capacity, Integer roomId);

}
