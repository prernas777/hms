package com.hexaware.hotelbookingsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hotelbookingsystem.dto.UsersDto;
//import com.hexaware.hotelbookingsystem.dto.UsersDto.UserRole;
import com.hexaware.hotelbookingsystem.entities.Users;
import com.hexaware.hotelbookingsystem.repository.UsersRepository;



@SpringBootTest
class UsersServiceImpTest {
	
	@Autowired
	IUsersService service;
	
	 @Mock
	 private UsersRepository usersRepository; // Mocked Repository

	 @InjectMocks
	 private UsersServiceImp usersService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	@Disabled
	void testAddUsersWithMocks() {
		UsersDto user = new UsersDto(7, "Kiran@gmail.com", "kiran@2000", "Kiran",  8987651190L, LocalDate.parse("2024-01-12"), "GUEST", LocalDate.parse("2024-01-12"));
	    

	    
	    Users mockUser = new Users(7, "Kiran@gmail.com", "kiran@2000", "Kiran",  8987651190L, LocalDate.parse("2024-01-12"), "GUEST", LocalDate.parse("2024-01-12"));

	    when(usersRepository.save(mockUser)).thenReturn(mockUser);
	    
	    Users savedUser = service.addUsers(user);

	    assertNotNull(savedUser, "Saved user should not be null");
	   
	}


	@Test
	@Disabled
	void testAddUsers() {
	
		UsersDto userDto = new UsersDto(5, "anusha@gmail.com", "anusha@2004", "Anusha", 8908796731L, LocalDate.parse("2024-07-10"), "GUEST", LocalDate.parse("2024-07-10"));

		Users user=service.addUsers(userDto);

		assertNotNull(user);
	}

	@Test
	@Disabled
	void testUpdateUsers() {
		UsersDto userDto=new UsersDto(5, "anusha@gmail.com", "anusha@2005", "Anusha", 8908796731L, LocalDate.parse("2024-07-10"), "GUEST", LocalDate.parse("2024-07-10"));
		Users user=service.updateUsers(userDto);
		
		assertNotNull(user);
		
		assertTrue(user.getName()=="Anusha");
		
	}

	@Test
	@Disabled
	void testGetUsersById() {
		
		Users user = service.getUsersById(1);

		assertEquals("Ganga", user.getName());
		
	}

	@Test
	@Disabled
	void testDeleteByName() {
		String userName = "Kiran";

		int  user=service.deleteByName(userName);
		

		assertNotNull(user);
	}
	
	@Test
	void testGetAllUsers() {

		List list = service.getAllUsers();

		boolean flag = list.isEmpty();

		assertFalse(flag);

	}


}
