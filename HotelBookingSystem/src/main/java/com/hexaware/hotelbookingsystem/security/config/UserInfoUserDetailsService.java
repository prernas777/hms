package com.hexaware.hotelbookingsystem.security.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.hotelbookingsystem.entities.Users;
import com.hexaware.hotelbookingsystem.repository.UsersRepository;
@Service
public class UserInfoUserDetailsService implements UserDetailsService {
	 @Autowired
	    private UsersRepository repository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<Users> user = repository.findByName(username);
	        
	        return user.map(UserInfoUserDetails::new) 
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

	    }

}
