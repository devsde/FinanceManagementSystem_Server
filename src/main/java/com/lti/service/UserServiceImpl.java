package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.dto.ForgetPasswordDto;
import com.lti.dto.LoginResponseDto;
import com.lti.dto.UpdateUserDto;
import com.lti.entity.User;
import com.lti.exception.UserIdMissingException;
import com.lti.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	EmailService emailService;
	
//	#Outlook
//	#spring.mail.properties.mail.smtp.connecttimeout=50000
//	#spring.mail.properties.mail.smtp.timeout=30000
//	#spring.mail.properties.mail.smtp.writetimeout=50000
//	#spring.mail.host=smtp.office365.com
//	#spring.mail.port=587
//	#spring.mail.username=CardHutBusiness@outlook.com
//	#spring.mail.password=CardHut123#
//	#spring.mail.properties.mail.smtp.starttls.enable=true
//	#spring.mail.properties.mail.smtp.auth=true


	public String signUp(User user) {
		// TODO Auto-generated method stub
		User persistedUser = userDao.addOrUpdateUser(user);
		if (persistedUser != null) {
			try {

				String subject = "Registration confirmation";
				String text = "Your user id is " + persistedUser.getUserId();
				String email = persistedUser.getEmail();
				emailService.sendEmailForSignup(email, text, subject);

				return "Sign up successful. Email verification mail has been sent to you";
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return "Unexpected error occured during email verification";
			}
		}
		else {
			return "Error occured during registration";
		}

	}
	

	

	public User findUser(int userId) {
		// TODO Auto-generated method stub4
		
		try {
			if(userId==0) {
				throw new UserIdMissingException("Enter correct userId");
			}
			else if(userDao.getUserById(userId)==null) {
				throw new UserNotFoundException("User does not exist");
			}
			else {
				return userDao.getUserById(userId);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
	
			return null;
		}
	
	}

	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return userDao.viewAllUsers();
	}

//	public LoginResponseDto userLogin(int userId, String password) {
//		// TODO Auto-generated method stub
//		return userDao.login(userId, password) ;
//	}

	public String addJoiningFee(int userId, double joiningFee) {
		// TODO Auto-generated method stub
		return null;
	}

	public UpdateUserDto updateUser(User user) {
		
		
		UpdateUserDto updatedUserDto = new UpdateUserDto();

		try {
			if (user.getUserId() == 0) {
				throw new UserIdMissingException("Please mention user id.");
			} else if (userDao.getUserById(user.getUserId()) == null) {
				throw new UserNotFoundException("User not found.");
			} else {
			
				User updatedUser = userDao.addOrUpdateUser(user);
				
				updatedUserDto.setUser(updatedUser);
				updatedUserDto.setMessage("User has been updated");
				return updatedUserDto;
			}
		} catch (Exception e) {
			updatedUserDto.setMessage(e.getMessage());
			return updatedUserDto;
		}
	}


	public ForgetPasswordDto forgotPassword(int userId) {
		// TODO Auto-generated method stub
		
		return userDao.forgotPassword(userId);
	}

}