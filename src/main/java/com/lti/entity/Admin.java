package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN_LOGIN")
public class Admin {
	
	@Id
	@SequenceGenerator(name="admin_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "admin_seq", strategy = GenerationType.SEQUENCE)
	private int adminId;
	private String adminUsername;
	private String adminPassword;
	
	//Getters and Setters
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	public Admin() {

	}
	
	//Parameterized Constructors
	public Admin(int adminId, String adminUsername, String adminPassword) {
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
		
}
