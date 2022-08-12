package com.lti.service;

import java.util.List;

import com.lti.dto.UpdateProductDto;
import com.lti.entity.Product;

public interface ProductService {
	UpdateProductDto addProduct(Product product);
	Product findProduct(int productId);
	List<Product> viewProducts();
	UpdateProductDto updateProduct(Product product);
	
}
