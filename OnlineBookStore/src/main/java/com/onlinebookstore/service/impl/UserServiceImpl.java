package com.onlinebookstore.service.impl;

import com.onlinebookstore.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.onlinebookstore.entity.Customer;
import com.onlinebookstore.entity.UserDto;
import com.onlinebookstore.entity.UserLogin;
import com.onlinebookstore.repo.CustomerRepo;
import com.onlinebookstore.service.UserService;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Configuration
public class UserServiceImpl implements UserService{
	
	@Autowired
	private CustomerRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	  @Bean
	   public  ModelMapper modelMapper() {
	      ModelMapper modelMapper = new ModelMapper();
	      return modelMapper;
	   }
	
	@Override
	public Customer saveUser(UserDto user) {
		Customer customer= dtoToCustomer(user);
		Customer emp = null;
		String encodedPassword = passwordEncoder.encode(customer.getPassword());
		customer.setPassword(encodedPassword);
		customer.setRoles(Arrays.asList(new Role("ROLE_USER")));
		Customer existingUser = userRepo.getByEmail(user.getEmail());
	        if(existingUser == null){
	            return emp = userRepo.save(customer);
	        }else{
	              new Exception("User already exist");
	        }
		return null;
	}

	private  Customer dtoToCustomer(UserDto userDto) {
		Customer user= modelMapper().map(userDto, Customer.class);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Customer user = userRepo.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
