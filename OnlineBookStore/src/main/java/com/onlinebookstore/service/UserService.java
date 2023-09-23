package com.onlinebookstore.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.onlinebookstore.entity.Customer;
import com.onlinebookstore.entity.UserDto;
import com.onlinebookstore.entity.UserLogin;

public interface UserService extends UserDetailsService {
	Customer saveUser(UserDto userDto);
	UserLogin userLogin(UserLogin userLogin);
}
