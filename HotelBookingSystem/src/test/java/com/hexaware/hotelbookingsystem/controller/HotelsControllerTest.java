package com.hexaware.hotelbookingsystem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.hotelbookingsystem.HotelBookingSystemApplication;
import com.hexaware.hotelbookingsystem.dto.HotelsDto;
import com.hexaware.hotelbookingsystem.entities.Hotels;


@SpringBootTest(classes = HotelBookingSystemApplication.class)
class HotelsControllerTest {
	
	@Autowired
	RestTemplate restTemplate;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Disabled
	void testInsert() {
		
		
		HotelsDto hotelDto = new HotelsDto(104, "Grand Plaza", "Main Street Jayanagar", "Bangalore", "Luxurious hotel in the heart of the city.", 1234567890L, 4.5,4);


		Hotels  hotel  =  
				restTemplate.postForObject("http://localhost:8080/api/hotels/insert", hotelDto, Hotels.class);
		
							
								assertEquals(104, hotel.getHotelId());	
								
		
	}

	@Test
	@Disabled
	void testDelete() {
        int hotelId = 101;
		
		restTemplate.delete("http://localhost:8080/api/hotels/delete/"+hotelId);
		
	}

	@Test
	@Disabled
	void testGetById() {
		int hotelId = 101;

		ResponseEntity<Hotels> response = restTemplate.getForEntity("http://localhost:8080/api/hotels/getbyid/" + hotelId,
				Hotels.class);

		Hotels hotel = response.getBody();

		assertNotNull(hotel);
		
	}

	@Test
	void testGetAll() {
		
      List<Hotels> list =	restTemplate.getForObject("http://localhost:8080/api/hotels/getall", List.class);
		
		assertNotNull(list);
		
	}



}
