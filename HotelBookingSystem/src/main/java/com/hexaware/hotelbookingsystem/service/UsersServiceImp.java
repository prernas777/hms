/*
 *service class implementation  for users
 *Author : Ganga
 *Date: 2024-11-22
 * */
package com.hexaware.hotelbookingsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.hotelbookingsystem.dto.UsersDto;
import com.hexaware.hotelbookingsystem.entities.Users;

import com.hexaware.hotelbookingsystem.repository.UsersRepository;

import jakarta.transaction.Transactional;


@Transactional
@Service
public class UsersServiceImp implements IUsersService {
	
	@Autowired 
	UsersRepository repo;
	
	Logger logger=LoggerFactory.getLogger(UsersServiceImp.class);
	
	  @Autowired
	  private PasswordEncoder passwordEncoder;
	
	@Override
	public Users addUsers(UsersDto userDto) {
		
		Users user = new Users();
		
		user.setUserId(userDto.getUserId());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setName(userDto.getName());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setDateCreated(userDto.getDateCreated());
		user.setUserRole(userDto.getUserRole());
		user.setUpdatedAt(userDto.getUpdatedAt());
		
       //user.setPassword(passwordEncoder.encode(user.getPassword()));
		logger.info("Users add service is called");
		return repo.save(user);
	}
	

	@Override
	public Users updateUsers(UsersDto userDto) {
		
        Users user = new Users();
        //UserRole role = UserRole.valueOf(userDto.getUserrole());
        
		user.setUserId(userDto.getUserId());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setName(userDto.getName());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setDateCreated(userDto.getDateCreated());
		user.setUserRole(userDto.getUserRole());
		user.setUpdatedAt(userDto.getUpdatedAt());
		
		logger.info("Users update service is called");
		return repo.save(user);
	}

	@Override
	public Users getUsersById(Integer userId) {
		
		return repo.findById(userId).orElse(null);
	}

	@Override
	public void deleteUsersById(Integer userId) {
		
		
		repo.deleteById(userId);
		
		logger.debug("Record deleted by service");
		
	}

	@Override
	public List<Users> getAllUsers() {
		
		
		logger.info("All records of users is fetched");
		return repo.findAll();
	}


	@Override
	public int deleteByName(String name) {
		
		return repo.deleteByName(name);
	}


	@Override
	public int updatePhoneNumber(Long phoneNumber, Integer userId) {
		
		return repo.updatePhoneNumber(phoneNumber, userId);
	}


	@Override
	public int updatePassword(String password, Integer userId) {
		
		return repo.updatePassword(password, userId);
	}


	@Override
	public Users getByName(String name) {
		
		return repo.findByName(name).orElse(null);
	}


	





}
