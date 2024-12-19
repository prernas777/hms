package com.hexaware.hotelbookingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.hotelbookingsystem.dto.RoomsDto.RoomType;
import com.hexaware.hotelbookingsystem.entities.Rooms;
import com.hexaware.hotelbookingsystem.entities.Users;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms ,Integer> {
	
	@Modifying
	  @Query("update Rooms r set r.pricePerNight=:price where r.roomId=:id")
	  int updatepricePerNight(Integer price, Integer id);
	
	@Modifying
	  @Query("update Rooms r set r.capacity=:capacity where r.roomId=:id")
	int  updateCapacity(Integer capacity, Integer id);
	
	

}
