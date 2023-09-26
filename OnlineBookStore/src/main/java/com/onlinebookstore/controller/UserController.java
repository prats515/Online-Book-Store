package com.onlinebookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.entity.Customer;
import com.onlinebookstore.entity.UserDto;
import com.onlinebookstore.entity.UserLogin;
import com.onlinebookstore.repo.CustomerRepo;
import com.onlinebookstore.service.UserService;

@Controller
//@RequestMapping("/registration")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private CustomerRepo customerRepo;

	
	@PostMapping("/registrationmethod")
	public String registerUserAccount(@ModelAttribute("user") UserDto registrationDto) {
		userService.saveUser(registrationDto);
		return "redirect:/registration?success";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/home")
	public String home() {
		return "index";
	}

//	@PostMapping("/registration")
//	public ResponseEntity<Customer> saveEmployeeDetails(@RequestBody UserDto user) throws Exception {
//		Customer employee1 = userService.saveUser(user);
//		return new ResponseEntity<>(employee1, HttpStatus.OK);
//	}
//
/*	@PostMapping("/user_login")
	public ResponseEntity<UserLogin> employeesLogin(@RequestBody UserLogin userLogin) throws Exception {
		UserLogin users = userService.userLogin(userLogin);
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}*/
//
//	@GetMapping("/getusers")
//	public String getAllUsers(Model model) {
//		model.addAttribute("user", customerRepo.findAll());
//		return "user";
//	}
	
	@ModelAttribute("user")
	public UserDto userDto() {
		return new UserDto();
	}
	
	@GetMapping("/registration")
	private String showRegistrationForm() {
		return "registration";
	}
//	@GetMapping("/register")
//	private String showRegistrationForm(Model model) {
//		model.addAttribute("user", new UserDto());
//		return "registration";
//	}
	
}
