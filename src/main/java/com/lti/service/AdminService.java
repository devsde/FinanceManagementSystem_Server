package com.lti.service;

public interface AdminService {
	boolean activateUserAndAddCard(int emiCardNo);
	boolean adminLogin(String adminUsername, String adminPassword);
}
