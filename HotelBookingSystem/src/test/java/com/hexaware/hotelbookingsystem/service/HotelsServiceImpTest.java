package com.hexaware.hotelbookingsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hotelbookingsystem.dto.HotelsDto;
import com.hexaware.hotelbookingsystem.entities.Hotels;




@SpringBootTest
class HotelsServiceImpTest {
	
	@Autowired
	IHotelsService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Disabled
	void testAddHotels() {
		
		HotelsDto hotelDto = new HotelsDto(101, "The Grand Hotel", "Main Street", "Hybderbad", "Luxury 5-star hotel", 9876543210L, 4.7,5);


		Hotels hotel=service.addHotels(hotelDto);

		assertNotNull(hotel);
		
		
	}

	@Test
	@Disabled
	void testUpdateHotels() {
		HotelsDto hotelDto = new HotelsDto();

		Hotels hotel=service.updateHotels(hotelDto);
		
		assertNotNull(hotel);
		
		assertTrue(hotel.getHotelName()=="Rajhotel");
		
	}

	@Test
	@Disabled
	void testGetHotelById() {
		Hotels hotel=service.getHotelById(101);


		assertEquals("Rajhotel", hotel.getHotelName());
		
	}

	@Test
	@Disabled
	void testDeleteHotelsById() {
		int hotelId = 103;

		service.deleteHotelsById(hotelId);

		assertNotNull(hotelId);


		
	}

	@Test
	@Disabled
	void testGetAllHotels() {
		
		List list = service.getAllHotels();

		boolean flag = list.isEmpty();

		assertFalse(flag);
		
	}



}
