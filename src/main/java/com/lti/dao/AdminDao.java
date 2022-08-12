package com.lti.dao;

import com.lti.entity.Admin;

public interface AdminDao {
	Admin addAdmin(Admin admin);
	boolean activateUserAndAddCard(int userId);
	boolean adminLogin(String adminUsername, String adminPassword);
}
