/*
 *service class implementation  for rooms
 *Author : Ganga
 *Date: 2024-11-22
 * */
package com.hexaware.hotelbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotelbookingsystem.dto.RoomsDto;
import com.hexaware.hotelbookingsystem.dto.RoomsDto.RoomType;
import com.hexaware.hotelbookingsystem.entities.Hotels;
import com.hexaware.hotelbookingsystem.entities.Rooms;
import com.hexaware.hotelbookingsystem.entities.Users;
import com.hexaware.hotelbookingsystem.repository.RoomsRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class RoomsServiceImp implements IRoomsService {
	@Autowired 
	RoomsRepository repo;
	@Autowired
	IHotelsService service;
	
	Logger logger=LoggerFactory.getLogger(RoomsServiceImp.class);

	@Override
	public Rooms addRooms(RoomsDto roomDto) {
		Rooms room=new Rooms();
		room.setRoomId(roomDto.getRoomId());
		room.setRoomNumber(roomDto.getRoomNumber());
		room.setRoomType(Rooms.RoomType.valueOf(roomDto.getRoomType().name()));
		room.setPricePerNight(roomDto.getPricePerNight());
		room.setAvailabilityStatus(Rooms.AvailabilityStatus.valueOf(roomDto.getAvailabilityStatus().name()));
		room.setCapacity(roomDto.getCapacity());
		room.setDescription(roomDto.getDescription());
		Hotels hotel=service.getHotelById(roomDto.getHotelId());
		room.setHotel(hotel);
		
		logger.info("Rooms add service is called");
		return repo.save(room);
	}

	@Override
	public Rooms updateRooms(RoomsDto roomDto) {
		Rooms room=new Rooms();
		room.setRoomId(roomDto.getRoomId());
		room.setRoomNumber(roomDto.getRoomNumber());
		room.setRoomType(Rooms.RoomType.valueOf(roomDto.getRoomType().name()));
		room.setPricePerNight(roomDto.getPricePerNight());
		room.setAvailabilityStatus(Rooms.AvailabilityStatus.valueOf(roomDto.getAvailabilityStatus().name()));
		room.setCapacity(roomDto.getCapacity());
		room.setDescription(roomDto.getDescription());
		
		logger.info("Rooms update service is called");
		return repo.save(room);
	}

	@Override
	public Rooms getRoomById(Integer roomId) {
		
		return repo.findById(roomId).orElse(null);
	}

	@Override
	public void deleteRoomsById(Integer roomId) {
		
		repo.deleteById(roomId);
		logger.debug("Record deleted by service");
		
	}

	@Override
	public List<Rooms> getAllRooms() {
		logger.info("All records of rooms is fetched");
		return  repo.findAll();
	}

	@Override
	public int updatepricePerNight(Integer pricePerNight, Integer roomId) {
		
		return repo.updatepricePerNight(pricePerNight, roomId);
	}

	@Override
	public int updateCapacity(Integer capacity, Integer roomId) {
		
		return repo.updateCapacity(capacity, roomId);
	}




	


}
