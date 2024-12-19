package com.hexaware.hotelbookingsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hotelbookingsystem.dto.RoomsDto;
import com.hexaware.hotelbookingsystem.dto.RoomsDto.AvailabilityStatus;
import com.hexaware.hotelbookingsystem.dto.RoomsDto.RoomType;
import com.hexaware.hotelbookingsystem.entities.Rooms;

@SpringBootTest
class RoomsServiceImpTest {
	
	@Autowired
	IRoomsService service;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Disabled
	void testAddRooms() {
		RoomsDto roomDto = new RoomsDto(1002, 12, RoomType.DOUBLE, 3500.0, AvailabilityStatus.AVAILABLE, 2, "Spacious", 102);


		Rooms room=service.addRooms(roomDto);

		assertNotNull(room);
	}

	@Test
	@Disabled
	void testUpdateRooms() {
		
		RoomsDto roomDto = new RoomsDto(1002, 12, RoomType.DOUBLE, 3500.0, AvailabilityStatus.AVAILABLE, 2, "Good View", 102);

		Rooms room=service.updateRooms(roomDto);
		
		assertNotNull(room);
		
		
	}

	@Test
	@Disabled
	void testGetRoomById() {
		
		Rooms room=service.getRoomById(1001);
		
		assertNotNull(room);
		
	}


	@Test
	@Disabled
	void testGetAllRooms() {
		List list = service.getAllRooms();

		boolean flag = list.isEmpty();

		assertFalse(flag);
		
	}

	

}
