package com.lti.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.dao.AdminDao;
import com.lti.entity.Admin;

public class AdminDaoTest {

	AdminDao dao;
	
	@BeforeEach
	public void initializeDao() {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/dispatcher-servlet.xml");
		dao = context.getBean(AdminDao.class);
	}
	
	@Test
	public void addAdminTest() {
		Admin admin = new Admin();
		admin.setAdminUsername("Admin");
		admin.setAdminPassword("Admin@123");
		
		Admin savedAdmin = dao.addAdmin(admin);
		assertNotNull(savedAdmin);
		System.out.println(savedAdmin.getAdminId()+" "+savedAdmin.getAdminUsername()+" "+savedAdmin.getAdminPassword());
	}

	@Test
	public void activateCardTest() {
		assertTrue(dao.activateUserAndAddCard(200));
	}
	
	@Test
	public void adminLoginTest() {	
//		assertTrue("Invalid credentials", dao.login(2, "Dhw@1234"));
//		System.out.println("Login Successful");
		
		boolean b = dao.adminLogin("Admin", "Admin@123");
        assertTrue(b);
	}
}
