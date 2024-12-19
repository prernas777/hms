package com.hexaware.hotelbookingsystem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.hotelbookingsystem.entities.Users;


@SpringBootTest
class UsersControllerTest {
	
	@Autowired
	RestTemplate restTemplate;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Disabled
	void testInsert() {
		
		Users user = new Users(6, "kavana@gmail.com", "kavana@2000", "Kavana",8979678911L, LocalDate.parse("2024-03-20"), "GUEST", LocalDate.parse("2024-03-20"));

		ResponseEntity<Users>  response =  
				restTemplate.postForEntity("http://localhost:8080/api/users/insert", user, Users.class);

							Users u = response.getBody();
							
								assertEquals(6, u.getUserId());	
	}



	@Test
	@Disabled
	void testDelete() {
		int userId = 1;
		
		restTemplate.delete("http://localhost:8080/api/users/delete/"+userId);
	}

	@Test
	@Disabled
	void testGetById() {
		int userId = 1;

		ResponseEntity<Users> response = restTemplate.getForEntity("http://localhost:8080/api/users/getbyid/" + userId,
				Users.class);

		Users user = response.getBody();

		assertNotNull(user);
	}

	@Test
	@Disabled
	void testGetAll() {
		
		List<Users> list =	restTemplate.getForObject("http://localhost:8080/api/users/getall", List.class);
		
		assertNotNull(list);
		
	}

}
