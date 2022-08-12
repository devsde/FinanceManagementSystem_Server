package com.lti.dao;

import java.util.List;

import com.lti.entity.Product;
import com.lti.entity.Transaction;

public interface ProductDao {
	 
	 Product addOrUpdateProduct(Product product);
	 Product getProductById(int productId);
	 List<Product> viewAllProducts();
	 
}
