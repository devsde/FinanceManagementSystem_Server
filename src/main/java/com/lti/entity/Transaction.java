package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	@Id
	@SequenceGenerator(name="transaction_seq",initialValue = 5001,allocationSize = 1)
	@GeneratedValue(generator = "transaction_seq", strategy = GenerationType.SEQUENCE)
	private int transactionId;
	private int emiScheme;	
	private LocalDate orderDate;
	private double paidAmount;
	private double balanceAmount;
	private double totalAmount;
	private int emiPaid;
	private int emiRemaining;
	
	//Mappings
	@ManyToOne
	@JoinColumn(name="emiCardNo")
	EmiCard emiCard;
	
	@ManyToOne
	@JoinColumn(name="productId")
	Product product;
	
	
	public Transaction() {
		
	}
	
	//Parameterized Constructors
	
	public Transaction(int transactionId, int emiScheme, LocalDate orderDate, double paidAmount, double balanceAmount,
			double totalAmount, int emiPaid, int emiRemaining, EmiCard emiCard, Product product) {
		super();
		this.transactionId = transactionId;
		this.emiScheme = emiScheme;
		this.orderDate = orderDate;
		this.paidAmount = paidAmount;
		this.balanceAmount = balanceAmount;
		this.totalAmount = totalAmount;
		this.emiPaid = emiPaid;
		this.emiRemaining = emiRemaining;
		this.emiCard = emiCard;
		this.product = product;
	}

	//Getters and Setters
	
	public int getTransactionId() {
		return transactionId;
	}


	

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public int getEmiScheme() {
		return emiScheme;
	}


	public void setEmiScheme(int emiScheme) {
		this.emiScheme = emiScheme;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public double getPaidAmount() {
		return paidAmount;
	}


	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}


	public double getBalanceAmount() {
		return balanceAmount;
	}


	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}


	public EmiCard getEmiCard() {
		return emiCard;
	}


	public void setEmiCard(EmiCard emiCard) {
		this.emiCard = emiCard;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	public int getEmiPaid() {
		return emiPaid;
	}

	public void setEmiPaid(int emiPaid) {
		this.emiPaid = emiPaid;
	}

	public int getEmiRemaining() {
		return emiRemaining;
	}

	public void setEmiRemaining(int emiRemaining) {
		this.emiRemaining = emiRemaining;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
}
