package com.lti.service;

import java.util.List;

import com.lti.dto.ForgetPasswordDto;
import com.lti.dto.LoginResponseDto;
import com.lti.dto.UpdateUserDto;
import com.lti.entity.User;

public interface UserService {
	String signUp(User user);
	
	UpdateUserDto updateUser(User user);
	
	User findUser(int userId);
	List<User> viewAllUsers();
//	LoginResponseDto userLogin(int userId,String password);
	
	ForgetPasswordDto forgotPassword(int userId);
	
	String addJoiningFee(int userId,double joiningFee);

}
