package com.lti.dao;

import java.util.List;

import com.lti.dto.ForgetPasswordDto;
import com.lti.dto.LoginResponseDto;
import com.lti.entity.User;

public interface UserDao {
	
	User addOrUpdateUser(User user);
	User getUserById(int userId);
	List<User> viewAllUsers();
//	LoginResponseDto login(int userId,String password);
	
	boolean addJoiningFee(int userId,double joiningFee);
	
	User activateUser(int userId);
	
	ForgetPasswordDto forgotPassword(int userId);
	
	


}