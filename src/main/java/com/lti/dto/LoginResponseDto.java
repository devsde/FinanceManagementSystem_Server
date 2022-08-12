package com.lti.dto;

import com.lti.entity.User;

public class LoginResponseDto {
	
	private String message;
	private User user;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
