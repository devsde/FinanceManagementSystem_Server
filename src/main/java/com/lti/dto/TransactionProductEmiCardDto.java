package com.lti.dto;

import com.lti.entity.EmiCard;
import com.lti.entity.Product;
import com.lti.entity.Transaction;

public class TransactionProductEmiCardDto {
	
	Transaction transaction;
	Product product;
	EmiCard emiCard;
	
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public EmiCard getEmiCard() {
		return emiCard;
	}
	public void setEmiCard(EmiCard emiCard) {
		this.emiCard = emiCard;
	}
	
	
}
