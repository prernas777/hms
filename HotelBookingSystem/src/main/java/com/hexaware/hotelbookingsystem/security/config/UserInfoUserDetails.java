package com.hexaware.hotelbookingsystem.security.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.hotelbookingsystem.entities.Users;


public class UserInfoUserDetails implements UserDetails {
	
    private String name;
    private String password;
    private List<GrantedAuthority> authorities;
    
    public UserInfoUserDetails(Users user) {
        name=user.getName();
        password=user.getPassword();
        authorities= Arrays.stream(user.getUserRole().split(","))
                .map(SimpleGrantedAuthority::new) // .map(str -> new SimpleGrantedAuthority(str))
                .collect(Collectors.toList());
    }

//    public UserInfoUserDetails(Users users) {
//        if (users.getUserrole() != null && !users.getUserrole().isEmpty()) {
//            // Process multiple roles
//            this.authorities = users.getUserrole().strip()
//                    .map(role -> new SimpleGrantedAuthority( role.name()))
//                    .collect(Collectors.toList());
//        } else if (users.getUserrole() != null) {
//            // Process a single role
//            this.authorities = Collections.singletonList(
//                    new SimpleGrantedAuthority( users.getUserrole().name())
//            );
//        } else {
//            this.authorities = Collections.emptyList();
//        }
//    }
    
//    public UserInfoUserDetails(Users users) {
//    	 name=users.getName();
//         password=users.getPassword();
//        if (users.getUserrole() != null) {
//            // Map the single UserRole to a SimpleGrantedAuthority
//            this.authorities = Collections.singletonList(
//                    new SimpleGrantedAuthority("ROLE_" + users.getUserrole().name())
//            );
//        } else {
//            this.authorities = Collections.emptyList(); // Default to an empty list if no role is present
//        }
//    }
    
    
//    public UserInfoUserDetails(Users users) {
//        name = users.getName();
//        password = users.getPassword();
//        if (users.getUserrole() != null) {
//            // Map UserRole directly without "ROLE_" prefix
//            this.authorities = Collections.singletonList(
//                    new SimpleGrantedAuthority(users.getUserrole().name())
//            );
//        } else {
//            this.authorities = Collections.emptyList();
//        }
//    }






    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
	
	

}
