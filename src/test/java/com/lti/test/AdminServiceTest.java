package com.lti.test;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.service.AdminService;

public class AdminServiceTest {
	
	AdminService service;

	@BeforeEach
	public void initializeDao() {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/dispatcher-servlet.xml");
		service = context.getBean(AdminService.class);
	}
	

	
	@Test
	public void adminLoginTest() {
		boolean b = service.adminLogin("Admin", "Admin@123");
        assertTrue(b);
	}

}
