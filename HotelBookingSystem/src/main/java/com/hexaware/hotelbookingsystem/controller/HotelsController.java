/*
 *Controller  for Hotels
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

import com.hexaware.hotelbookingsystem.dto.HotelsDto;
import com.hexaware.hotelbookingsystem.entities.Hotels;
import com.hexaware.hotelbookingsystem.exception.HotelNotFoundException;
import com.hexaware.hotelbookingsystem.service.IHotelsService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/hotels")
public class HotelsController {
	@Autowired
	IHotelsService service;
	
	Logger logger=LoggerFactory.getLogger(HotelsController.class);
	
	@PostMapping("/insert")
	public  Hotels  insert(@RequestBody HotelsDto hotelDto) {
		
		logger.info("Hotels object added successfully");
		
		return  service.addHotels(hotelDto);
	  }
	@PutMapping("/update")
	//@PreAuthorize("hasAuthority('ADMIN')")
	public Hotels   update(@RequestBody HotelsDto hotelDto) {
		
		logger.info("Hotels object updated successfully");
		
		  return service.updateHotels(hotelDto);
		  
	  }
	@DeleteMapping("/delete/{hotelId}")
	//@PreAuthorize("hasAuthority('ADMIN')")
	 public String   delete(@PathVariable  Integer hotelId) {
		  
		service.deleteHotelsById(hotelId);
		return "Record deleted for hotelId" +hotelId;
	  }
	  
	@GetMapping("/getbyid/{hotelId}")
	//@PreAuthorize("hasAuthority('GUEST')")
	public  Hotels  getById(@PathVariable Integer hotelId) {
		  Hotels hotel=null;
		  hotel= service.getHotelById(hotelId);
			    if (hotel == null) {
			        throw new HotelNotFoundException();
			    }
			    return hotel;
		  
	  }
	  
	  @GetMapping("/getall")
	  //@PreAuthorize("hasAuthority('ADMIN')")
	  public List<Hotels>  getAll(){
		  
		  return service.getAllHotels();
		  
	  }
	  @GetMapping("/getByCity/{city}")
	  //@PreAuthorize("hasAuthority('GUEST')")
	  public List<Hotels> getByCity(@PathVariable String city){
		  
		  return service.getByCity(city);
		  
	  }
	  @GetMapping("/getByRating/{rating}")
	  //@PreAuthorize("hasAuthority('GUEST')")
	  public List<Hotels> getByRating(@PathVariable Double rating){
		  
		  return service.getByRating(rating);
		  
	  }
	  

}
