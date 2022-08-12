package com.lti.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.entity.Product;
import com.lti.service.ProductService;

public class ProductServiceTest {
	
	ProductService service;

	@BeforeEach
	public void initializeDao() {
//		File file = new File("dispatcher-servlet.xml");
//		String path = file.getAbsolutePath();
		ApplicationContext context=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/dispatcher-servlet.xml");
		service=context.getBean(ProductService.class);
	}
	
	@Test
	public void addProduct() {
		Product product=new Product();
		product.setProductName("Samsung A31");
		product.setProductCost(9999);
		product.setProductDescription("Samsung A31");
		product.setProductImage("");
		
//		String savedProduct=service.addProduct(product);
//		System.out.println(savedProduct);
//		assertNotNull(savedProduct);
	}
	
	@Test
	public void searchProduct() {
		Product product=service.findProduct(1021);
		System.out.println(product.getProductName()+"\t"+product.getProductCost());
		assertNotNull(product);
	}
	
	@Test
	public void viewProducts() {
		List<Product> products=service.viewProducts();
		assertFalse(products.isEmpty());
		for(Product p:products) {
			System.out.println(p.getProductId() + " " +p.getProductName());
		}
	}

}
