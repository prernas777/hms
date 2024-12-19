/*
 *Controller  for Rooms
 *Author : Ganga
 *Date: 2024-11-16
 * */


package com.hexaware.hotelbookingsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotelbookingsystem.dto.RoomsDto;
import com.hexaware.hotelbookingsystem.dto.RoomsDto.RoomType;
import com.hexaware.hotelbookingsystem.entities.Rooms;
import com.hexaware.hotelbookingsystem.entities.Users;
import com.hexaware.hotelbookingsystem.exception.RoomNotFoundException;
import com.hexaware.hotelbookingsystem.service.IRoomsService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/rooms")
public class RoomsController {
	@Autowired
	IRoomsService service;
	
	Logger logger=LoggerFactory.getLogger(RoomsController.class);
	
	@PostMapping("/insert")
	  public  Rooms  insert(@RequestBody RoomsDto roomDto) {
		
		logger.info("Rooms object added successfully");
		
		return  service.addRooms(roomDto);
	  }
	@PutMapping("/update")
	//@PreAuthorize("hasAuthority('ADMIN')")
	  public Rooms   update(@RequestBody RoomsDto roomDto) {
		
		logger.info("Rooms object updated successfully");
		  return service.updateRooms(roomDto);
		  
	  }
	@DeleteMapping("/delete/{roomId}")
	//@PreAuthorize("hasAuthority('ADMIN')")
	  public String   delete(@PathVariable  Integer roomId) {
		  
		service.deleteRoomsById(roomId);
		return "Record deleted for roomId" +roomId;
	  }
	  
	  @GetMapping("/getbyid/{roomId}")
	  //@PreAuthorize("hasAuthority('GUEST')")
	  public  Rooms  getById(@PathVariable Integer roomId) {
		  Rooms room=null;
		  room= service.getRoomById(roomId);
			    if (room == null) {
			        throw new RoomNotFoundException();
			    }
			    return room;
		  
	  }
	  
	  @GetMapping("/getall")
	  //@PreAuthorize("hasAuthority('ADMIN')")
	  public List<Rooms>  getAll(){
		  
		  return service.getAllRooms();
		  
	  }
	  
		@PutMapping("/updatePricePerNight/{price}/{id}")
		@PreAuthorize("hasAuthority('ADMIN')")
		  public int  updatePricePerNight(@PathVariable Integer price ,@PathVariable Integer id) {
			
			  return service.updatepricePerNight(price, id);
			  
		  }
		@PutMapping("/updateCapacity/{capacity}/{id}")
		@PreAuthorize("hasAuthority('ADMIN')")
		  public int  updateCapacity(@PathVariable Integer capacity ,@PathVariable Integer id) {
			
			  return service.updateCapacity(capacity, id);
			  
		  }
		

}
