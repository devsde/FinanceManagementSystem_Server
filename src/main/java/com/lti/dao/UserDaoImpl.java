package com.lti.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.dto.ForgetPasswordDto;
import com.lti.dto.LoginResponseDto;
import com.lti.entity.User;
import com.lti.service.EmailService;


@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	EmailService emailService;

	
	@Transactional
	public User addOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		User persistedUser=null;
		
		try {
			persistedUser=em.merge(user);
			return persistedUser;
			
		} catch (Exception e) {
			// TODO: handle exception
			return persistedUser;
		}
		
		
	}

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		User user=null;
		try {
			user=em.find(User.class, userId);
			return user;
			
		} catch (Exception e) {
			// TODO: handle exception
			return user;
		}
		
	
	}

	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		String jpql="select u from User u";
		TypedQuery<User> query=em.createQuery(jpql, User.class);
		return query.getResultList();
	}

//	public LoginResponseDto login(int userId, String password) {
//		// TODO Auto-generated method stub
//		LoginResponseDto loginResponseDto=new LoginResponseDto();
//		String jpql="select u from User u where u.userId=:uid and u.userPassword=:pwd";
//		
//		TypedQuery<User> query=em.createQuery(jpql, User.class);
//		query.setParameter("uid", userId);
//		query.setParameter("pwd", password);
//		
//		
//		try {
//			User user=query.getSingleResult();
//			loginResponseDto.setUser(user);
//
//			if(user.isEligible()) {
//				
//				loginResponseDto.setMessage("");
//				
//				
//			}
//			else {
//				loginResponseDto.setMessage("You have not been validated by the admin");
//				
//				
//			}
//			return loginResponseDto;
//		}
//		catch(Exception e){
//			loginResponseDto.setUser(null);
//			loginResponseDto.setMessage("Invalid Credentials");
//	
//		}
//		
//		return loginResponseDto;
//	}
	

	public boolean addJoiningFee(int userId,double joiningFee) {
		// TODO Auto-generated method stub
		
		return false;
	}


//	@Transactional
//	public User activateUser(int userId) {
//		// TODO Auto-generated method stub
//		
//		User nonActiveUser=getUserById(userId);
//		nonActiveUser.setEligible(true);
//		try {
//			User activeUser=em.merge(nonActiveUser);
//			return activeUser;
//		} catch (Exception e) {
//			return null;
//			// TODO: handle exception
//		}
//		
//	}
	
	@Transactional
	public User activateUser(int userId) {
		String jpql = "update User u set u.eligible=:approve where u.userId=:uid";
		Query query = em.createQuery(jpql);
		query.setParameter("approve", true);
		query.setParameter("uid", userId);
		int rec = query.executeUpdate();
		if(rec!=0) {
			return getUserById(userId);
		}
		else {
			return null;
		}
	}

	
	public ForgetPasswordDto forgotPassword(int userId) {
		ForgetPasswordDto fp=new ForgetPasswordDto();
		User user=getUserById(userId);
		if(user==null) {
			fp.setOtp(0);
			fp.setMessage("User Does not exist");
			fp.setUser(user);
			return fp;
		}
		else {
			
			Random r = new Random( System.currentTimeMillis() );
		    int otp=((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
			String subject = "Reset Password";
			String text = "Your OTP to change password: "+otp;
			String email=user.getEmail();
			try {
				emailService.sendEmailForSignup(email, text, subject);
				fp.setOtp(otp);
				fp.setMessage("Otp sent on your registered email id");
				fp.setUser(user);
				return fp;
				
			} catch (Exception e) {
				fp.setOtp(0);
				fp.setMessage("Something went wrong.Try again after sometime");
				fp.setUser(user);
				return fp;
			}

			
			
		}

		
	}
	
	

}
