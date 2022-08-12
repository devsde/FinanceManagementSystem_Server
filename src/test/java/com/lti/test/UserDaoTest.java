//package com.lti.test;
//
//
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//
//import com.lti.dao.UserDao;
//import com.lti.dto.LoginResponseDto;
//import com.lti.entity.CardType;
//import com.lti.entity.User;
//
//public class UserDaoTest {
//
//	UserDao userDao;
//
//	@BeforeEach
//	public void initializeDao() {
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/dispatcher-servlet.xml");
//		userDao = context.getBean(UserDao.class);
//
//	}
//	
//
//	@Test
//	public void addOrUpdateUserTest() {
//
//		User user = new User();
//		user.setFullName("raj");
//		user.setEmail("raj@gmail.com");
//		
//		user.setUserPassword("raj123");
//		user.setUserPhone("7789456123");
//		user.setUserAddress("A wing ,room no-802");
//		user.setCardType(CardType.gold.toString());
//		user.setUserBank("HDFC");
//		user.setUserAccountNo("789456478945");
//		user.setUserIfsc("HDFC1234");
//		user.setEligible(false);
//
//		User savedUser = userDao.addOrUpdateUser(user);
//
//		assertNotNull(savedUser);
//	}
//
//	@Test
//	public void searchUserById() {
//		User user = userDao.getUserById(201);
//		System.out.println(user.getFullName());
//		assertNotNull(user);
//	}
//
//	@Test
//	public void viewAllUsers() {
//		List<User> users = userDao.viewAllUsers();
//		assertFalse(users.isEmpty());
//		for (User u : users) {
//			System.out.println(u.getUserId() + " " + u.getEmail());
//		}
//
//	}
//
//	@Test
//	public void login() {
//		boolean isValidUser = userDao.login(200, "john123").getUser().isEligible();
//		assertTrue(isValidUser);
//		
//	}
//
//}
