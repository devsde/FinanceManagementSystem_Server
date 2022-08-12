//package com.lti.test;
//
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//
//import com.lti.dto.UpdateUserDto;
//import com.lti.entity.CardType;
//import com.lti.entity.User;
//import com.lti.service.UserService;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.BeforeEach;
//
//public class UserServiceTest {
//	UserService userService;
//
//	@BeforeEach
//	public void initializeDao() {
//		ApplicationContext context = new FileSystemXmlApplicationContext(
//				"src/main/webapp/WEB-INF/dispatcher-servlet.xml");
//		userService = context.getBean(UserService.class);
//
//	}
//
//	@Test
//	public void signUp() {
//
//		
//		User user = new User();
//		user.setFullName("Kl Rahul");
//		user.setEmail("KlRahul@gmail.com");
//
//		user.setUserPassword("rahul123");
//		user.setUserPhone("7789456123");
//		user.setUserAddress("A wing ,room no-802");
//		user.setCardType(CardType.gold.toString());
//		user.setUserBank("HDFC");
//		user.setUserAccountNo("789456478945");
//		user.setUserIfsc("HDFC1234");
//
//		System.out.println(userService.signUp(user));
//
//	}
//	
//	@Test
//	public void updateUser() {
//		User user = new User();
//		user.setUserId(202);
//		user.setFullName("rishabh pant");
//		user.setEmail("rishabh123Agmail.com");
//
//		user.setUserPassword("rishabh123");
//		user.setUserPhone("7789456123");
//		user.setUserAddress("A wing ,room no-802");
//		user.setCardType(CardType.gold.toString());
//		user.setUserBank("HDFC");
//		user.setUserAccountNo("789456478945");
//		user.setUserIfsc("HDFC1234");
//
//		UpdateUserDto updateUser=userService.updateUser(user);
//		System.out.println(updateUser.getMessage());
//	}
//	
//	
//	@Test
//	public void getUserById() {
//		assertNotNull(userService.findUser(201));
//
//	}
//	
//	
//	@Test
//	public void viewAllUsers(){
//		assertNotEquals(0, userService.viewAllUsers().size());
//
//	}
//	
//	@Test
//	public void login() {
//		assertTrue(userService.userLogin(202, "john123").getUser().isEligible());
//		
//		
//	}
//	
//	@Test
//	public void addJoiningFee() {
//		
//	}
//}
