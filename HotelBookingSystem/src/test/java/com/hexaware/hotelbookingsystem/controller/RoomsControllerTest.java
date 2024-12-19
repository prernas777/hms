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

import com.hexaware.hotelbookingsystem.dto.RoomsDto;
import com.hexaware.hotelbookingsystem.entities.Hotels;
import com.hexaware.hotelbookingsystem.entities.Rooms;

@SpringBootTest
class RoomsControllerTest {
	
	@Autowired
	RestTemplate restTemplate;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Disabled
	void testInsert() {
		
		
		RoomsDto roomDto = new RoomsDto();


		Rooms  room  =  
				restTemplate.postForObject("http://localhost:8080/api/rooms/insert", roomDto, Rooms.class);
		
							
								assertEquals(1003, room.getRoomId());	
								
		
	}

	@Test
	@Disabled
	void testUpdate() {
		
	}

	@Test
	@Disabled
	void testDelete() {
		
		 int roomId = 101;
			
			restTemplate.delete("http://localhost:8080/api/rooms/delete/"+roomId);
		
	}

	@Test
	@Disabled
	void testGetById() {
		
		int roomId = 1;

		ResponseEntity<Rooms> response = restTemplate.getForEntity("http://localhost:8080/api/rooms/getbyid/" + roomId,
				Rooms.class);

		Rooms room = response.getBody();

		assertNotNull(room);
		
	}

	@Test
	@Disabled
	void testGetAll() {
		
	List<Rooms> list =	restTemplate.getForObject("http://localhost:8080/api/rooms/getall", List.class);
		
		assertNotNull(list);
		
	}



}
