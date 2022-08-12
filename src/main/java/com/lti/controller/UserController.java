package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ForgetPasswordDto;
import com.lti.dto.LoginDto;
import com.lti.dto.LoginResponseDto;
import com.lti.dto.UpdateUserDto;
import com.lti.entity.User;
import com.lti.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping(value = "/signup")
	public String signUp(@RequestBody User user) {
		String message = userService.signUp(user);
		return message;
	}

	@PutMapping(value = "/update")
	public UpdateUserDto update(@RequestBody User user) {
		UpdateUserDto updatedUser = userService.updateUser(user);
		return updatedUser;
	}

	@GetMapping(value = "/user/{userId}")
	public User findUser(@PathVariable int userId) {
		User user = userService.findUser(userId);
		return user;
	}

	@GetMapping("/viewAll")
	public List<User> viewAllUsers() {
		return userService.viewAllUsers();

	}

//	@PostMapping("/login")
//	public LoginResponseDto login(@RequestBody LoginDto dto) {
//		return userService.userLogin(dto.getUserId(), dto.getPassword());
//
//	}
	
	@PutMapping("/forgotPassword/{userId}")
	public ForgetPasswordDto forgotPassword(@PathVariable int userId) {
		return userService.forgotPassword(userId);
		
	}

}
