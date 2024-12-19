package com.hexaware.hotelbookingsystem.security.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.hexaware.hotelbookingsystem.filter.JwtAuthFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	//implements WebMvcConfigurer
	@Autowired
	JwtAuthFilter authFilter;

	   @Bean
	    //authentication
	    public UserDetailsService userDetailsService() {

	       return new UserInfoUserDetailsService();
	    }

	   @Bean
	   public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
	       return http.csrf(csrf -> csrf.disable())  // Disable CSRF protection if not needed
	                .cors(cors -> {})
	               .authorizeHttpRequests()
	               .requestMatchers("/api/users/insert", "/api/users/login/authenticate","/api/hotels/insert","/api/rooms/insert","/api/hotels/getbyid/**", "/api/users/getbyid/**","/api/hotels/getall","/api/rooms/getall","/api/hotels/getByCity/**","/api/hotels/getByRating/**","/api/rooms/getbyid/**","/api/users/getByName/**"
	            		   ,"/api/bookings/create","/api/payments/process","/api/reviews/add","/api/users/updatePhoneNumber/*/*","/api/users/update","/api/hotels/update","/api/rooms/update","/api/rooms/delete/**","/api/hotels/delete/**","/api/users/getall","/api/users/delete/**",
	            		   "/api/payments/process","/api/payments/getbyid/**","/api/payments/getbyid/**","/api/payments/cancel/**","/api/bookings/getbystatus","/api/reviews/add","/api/reviews/delete/**","/api/reviews/getbyid/**","/api/reviews/average-rating/**","/api/bookings/getbyid/**","/api/bookings/getall/","/v3/api-docs/*", "/swagger-ui/", "/swagger-ui.html", "/webjars/", "/swagger-resources/*").permitAll() // Public endpoints
	               .requestMatchers(HttpMethod.PUT,"/api/users/updatePassword/*/*").hasAuthority("GUEST") // Guest permissions
	               .requestMatchers(HttpMethod.DELETE, "/api/users/deleteByName/**","/api/users/delete/**").hasAuthority("ADMIN")
	               .requestMatchers(HttpMethod.PUT,  "/api/rooms/updatePricePerNight/*/*", "/api/rooms/updateCapacity/*/*","/api/users/updatePassword/*/*").hasAuthority("ADMIN")
	               .anyRequest().authenticated() // All other requests must be authenticated
	               .and()
	               .sessionManagement()
	               .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless sessions for APIs
	               .and()
	               .authenticationProvider(authenticationProvider()) // Custom authentication provider
	               .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class) // Adding custom filter
	               .build();
	   }


	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService());
	        authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	    }


	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

	    	return config.getAuthenticationManager();

	    }
//	    @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/**") // Apply CORS for all endpoints
//	                .allowedOrigins("http://localhost:4200") // Allow the frontend to access
//	                .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed HTTP methods
//	                .allowedHeaders("*") // Allow all headers
//	                .allowCredentials(true); // Allow credentials like cookies or HTTP authentication
//	    }



	    @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	        configuration.setAllowedHeaders(Arrays.asList("*"));
	        configuration.setAllowCredentials(true);
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }

}
