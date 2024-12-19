package com.hexaware.hotelbookingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.hotelbookingsystem.entities.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users ,Integer> {
	
	@Modifying
	  @Query("delete from  Users u where u.name=?1")
	  int deleteByName(String name);
	
	@Modifying
	  @Query("update Users u set u.phoneNumber=:phno where u.userId=:id")
	  int updatePhoneNumber(Long phno ,Integer id);
	
	@Modifying
	  @Query("update Users u set u.password=:pword where u.userId=:id")
	int updatePassword(String pword,Integer id);
	
	Optional<Users> findByName(String username);

}
