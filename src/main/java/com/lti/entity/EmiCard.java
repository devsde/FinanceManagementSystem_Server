package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="EMI_CARD")
public class EmiCard {
	
	@Id
	@SequenceGenerator(name="card_seq",initialValue = 2001,allocationSize = 1)
	@GeneratedValue(generator = "card_seq", strategy = GenerationType.SEQUENCE)
	private int emiCardNo;
	private String emiValidity;
	private String emiCardType;
	private double emiCardLimit;
	private double emiCardBalance;

	
	//Mappings
	@OneToOne
	@JoinColumn(name="userId")
	User user;
	
	@OneToMany(mappedBy = "emiCard",cascade = CascadeType.ALL)
	List<Transaction> transactions;
	
	public EmiCard() {
		
	}
	//Getters and Setters
	
	
	public int getEmiCardNo() {
		return emiCardNo;
	}

	public void setEmiCardNo(int emiCardNo) {
		this.emiCardNo = emiCardNo;
	}

	public String getEmiValidity() {
		return emiValidity;
	}

	public void setEmiValidity(String emiValidity) {
		this.emiValidity = emiValidity;
	}

	public String getEmiCardType() {
		return emiCardType;
	}

	public void setEmiCardType(String emiCardType) {
		this.emiCardType = emiCardType;
	}

	public double getEmiCardLimit() {
		return emiCardLimit;
	}

	public void setEmiCardLimit(double emiCardLimit) {
		this.emiCardLimit = emiCardLimit;
	}

	public double getEmiCardBalance() {
		return emiCardBalance;
	}

	public void setEmiCardBalance(double emiCardBalance) {
		this.emiCardBalance = emiCardBalance;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	

	
	//Parameterized Constructors
	

	
}
