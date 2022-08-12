package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;

	public boolean activateUserAndAddCard(int userId) {
		if(adminDao.activateUserAndAddCard(userId)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean adminLogin(String adminUsername, String adminPassword) {
		return adminDao.adminLogin(adminUsername, adminPassword);
	}

}
