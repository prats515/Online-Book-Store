package com.onlinebookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.onlinebookstore.entity.Customer;
import com.onlinebookstore.entity.UserDto;
import com.onlinebookstore.entity.UserLogin;
import com.onlinebookstore.repo.CustomerRepo;
import com.onlinebookstore.service.UserService;

@Service
@Configuration
public class UserServiceImpl implements UserService{
	
	@Autowired
	private CustomerRepo userRepo;
	
	  @Bean
	   public  ModelMapper modelMapper() {
	      ModelMapper modelMapper = new ModelMapper();
	      return modelMapper;
	   }
	
	@Override
	public Customer saveUser(UserDto user) {
		Customer customer= dtoToCustomer(user);
		Customer emp = null;
		Customer existingUser = userRepo.getByEmail(user.getEmail());
	        if(existingUser == null){
	            return emp = userRepo.save(customer);
	        }else{
	              new Exception("User already exist");
	        }
		return null;
	}
	@Override
	public UserLogin userLogin(UserLogin userLogin) {
        Iterable<Customer> allUser = userRepo.findAll();
        for (Customer user : allUser) {
            if (user.getEmail().equals(userLogin.getUsername()) && user.getPassword().equals(userLogin.getPassword())) {
                return userLogin;
            }
        }
        return null;
    }
	private  Customer dtoToCustomer(UserDto userDto) {
		Customer user= modelMapper().map(userDto, Customer.class);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



}
