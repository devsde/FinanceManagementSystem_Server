package com.lti.dto;

import com.lti.entity.Product;

public class UpdateProductDto {

	String msg;
	Product product;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
