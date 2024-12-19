/*
 *Interface  for Users
 *Author : Ganga
 *Date: 2024-11-15
 * */package com.hexaware.hotelbookingsystem.service;

import java.util.List;

import com.hexaware.hotelbookingsystem.dto.UsersDto;
import com.hexaware.hotelbookingsystem.entities.Users;


public interface IUsersService {
	
	
   public Users addUsers(UsersDto userDto);
	
	public Users updateUsers(UsersDto userDto);
	
	public Users getUsersById(Integer userId);
	
	public void deleteUsersById(Integer userId);
	
	public List<Users> getAllUsers();
	
    public int deleteByName(String name);
	
	public int updatePhoneNumber(Long phoneNumber ,Integer userId);
	
	public int updatePassword(String password,Integer userId);

	//public String addUser(Users user);
	
	public Users getByName(String name);
	
}
