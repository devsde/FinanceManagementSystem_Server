//package com.lti.test;
//
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.time.LocalDate;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//
//import com.lti.dao.TransactionDao;
//import com.lti.dao.TransactionDaoImpl;
//import com.lti.entity.Transaction;
//import com.lti.service.TransactionService;
//
//public class TransactionDaoTest {
//	
//	TransactionDao dao;
//	TransactionService ts;
//	@BeforeEach
//	public void initializeDao() {
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/dispatcher-servlet.xml");
//		ts = context.getBean(TransactionService.class);
//	}
//
//
//	@Test
//	public void addTransactionTest() {
//		Transaction transaction=new Transaction();
////		transaction.setUserId(101);   //uncomment this later
////		transaction.setProductId(207);    //uncomment this later
//		transaction.setPaidAmount(5000);
//		transaction.setOrderDate(LocalDate.of(2022, 07, 22));
//		transaction.setBalanceAmount(60000);
//		transaction.setEmiScheme(3);
////		transaction.setCardNo(2001);    //uncomment this later
//		String transaction2=ts.addOrUpdateTransaction(transaction);
//		System.out.println(transaction2);
//		assertNotNull(transaction2);
//	}
//	@Test
//	public void searchemitest() {
//		assertNotEquals(ts.viewTransactionByCardNo(2002).size(),0);
//	}
//	@Test
//	public void searchproducttest() {
//		assertNotEquals(ts.viewTransactionsByProductId(201).size(),0);
//	}
//
//}
