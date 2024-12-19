/*
 *Controller  for Users
 *Author : Ganga
 *Date: 2024-11-16
 * */
package com.hexaware.hotelbookingsystem.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotelbookingsystem.dto.AuthRequest;
import com.hexaware.hotelbookingsystem.dto.UsersDto;
import com.hexaware.hotelbookingsystem.entities.Users;
import com.hexaware.hotelbookingsystem.exception.UserNotFoundException;
import com.hexaware.hotelbookingsystem.service.IUsersService;
import com.hexaware.hotelbookingsystem.service.JwtService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/users")
public class UsersController {
	@Autowired
	IUsersService service;
	
	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;
	
	Logger logger=LoggerFactory.getLogger(UsersController.class);
	
	@PostMapping("/insert")
	  public  Users  insert(@RequestBody UsersDto userDto) {
		
		logger.info("Users object added successfully");
		return  service.addUsers(userDto);
		

	  }
	
	@PostMapping("/login/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		String token = null;

		if (authentication.isAuthenticated()) {

			// call generate token method from jwtService class

			token = jwtService.generateToken(authRequest.getUsername());

			logger.info("Token : " + token);

		} else {

			logger.info("invalid");

			throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");

		}

		return token;

	}
	@PutMapping("/update")
	//@PreAuthorize("hasAuthority('ADMIN')")
	  public  Users    update(@RequestBody UsersDto userDto) {
		
		logger.info("Users object updated successfully");
		
		  return service.updateUsers(userDto);
		  
	  }
	@DeleteMapping("/delete/{userId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	  public String   delete(@PathVariable  Integer userId) {
		  
		service.deleteUsersById(userId);
		return "Record deleted for UserId" +userId;
	  }
	 
	
	@GetMapping("/getbyid/{userId}")
	public Users getById(@PathVariable Integer userId) {
	    return Optional.ofNullable(service.getUsersById(userId))
	            .orElseThrow(() -> new UserNotFoundException());
	}

	  
	  @GetMapping("/getall")
	  //@PreAuthorize("hasAuthority('ADMIN')")
	  public List<Users>  getAll(){
		  
		  return service.getAllUsers();
		  
	  }
	  @DeleteMapping("/deleteByName/{name}")
	  @PreAuthorize("hasAuthority('ADMIN')")
	  public String   deleteByName(@PathVariable String name ) {
		  
		service.deleteByName(name);
		return "Record deleted for name " +name;
	  }
	  
	  @PutMapping("/updatePhoneNumber/{phno}/{id}")
	 // @PreAuthorize("hasAuthority('GUEST')")
	  public  int   updatePhoneNumber(@PathVariable Long phno, @PathVariable Integer id) {
		
		  return service.updatePhoneNumber(phno, id);
		  
	  }
	  @PutMapping("/updatePassword/{pword}/{id}")
	  @PreAuthorize("hasAuthority('ADMIN')")
	  public  int    updatePassword(@PathVariable String pword, @PathVariable Integer id) {
		
		  return service.updatePassword(pword, id);
		  
	  }
	  @GetMapping("/getByName/{name}")
	  //@PreAuthorize("hasAuthority('ADMIN')")
	  public Users getByName(@PathVariable String name)
	  {
		  return service.getByName(name);
	  }
	  

}
