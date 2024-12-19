/*
 *Dto class For users
 *Author : Ganga
 *Date: 2024-11-20
 * */
package com.hexaware.hotelbookingsystem.dto;

import java.time.LocalDate;


public class UsersDto {
	
	private Integer userId;
	private String email;
	private String password;
	private String name;
	private Long phoneNumber;
	private LocalDate dateCreated;
	private String userRole;
	private LocalDate updatedAt;
	
//	public enum UserRole {
//		GUEST, HOTELOWNER , ADMIN
//	}

	public UsersDto(Integer userId, String email, String password, String name, Long phoneNumber, LocalDate dateCreated,
			String userRole, LocalDate updatedAt) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dateCreated = dateCreated;
		this.userRole = userRole;
		this.updatedAt = updatedAt;
	}

	public UsersDto() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}




}
