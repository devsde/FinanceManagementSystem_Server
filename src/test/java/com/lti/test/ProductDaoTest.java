package com.lti.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.dao.ProductDao;
import com.lti.entity.Product;

public class ProductDaoTest {
	
	ProductDao dao;
	
	@BeforeEach
	public void initializeDao() {
//		File file = new File("dispatcher-servlet.xml");
//		String path = file.getAbsolutePath();
		ApplicationContext context=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/dispatcher-servlet.xml");
		dao=context.getBean(ProductDao.class);
	}

	@Test
	public void testAddOrUpdateProduct(){
		Product product=new Product();
		product.setProductName("Samsung Galaxy Tab S6 Lite");
		product.setProductCost(31999);
		product.setProductDescription("Samsung Galaxy Tab S6 Lite");
		product.setProductImage("");
		
		Product savedProduct=dao.addOrUpdateProduct(product);
		assertNotNull(savedProduct);			
	}
	
	@Test
	public void testGetProductById() {
		Product product=dao.getProductById(1001);
		assertNotNull(product);
	}
	
	@Test
	public void testViewAllProducts() {
		List<Product> products=dao.viewAllProducts();
		assertFalse(products.isEmpty());
		for(Product p:products) {
			System.out.println(p.getProductId() + " " +p.getProductName());
		}
	}

}
