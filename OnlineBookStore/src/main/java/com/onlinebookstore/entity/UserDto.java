package com.onlinebookstore.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class UserDto {
	
	private String firstName;
	
	private String lastName;
	
	private String mobNumber;
	
	private String email;
	
	private String password;

	public UserDto(){
		
	}

}
