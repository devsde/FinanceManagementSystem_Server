package com.lti.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.dao.EmiCardDao;
import com.lti.dao.UserDao;
import com.lti.entity.CardType;
import com.lti.entity.EmiCard;
import com.lti.entity.User;


public class EmiCardDaoTest {

	EmiCardDao dao;
	UserDao dao1;
	
	@BeforeEach
	public void initializeDao() {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/dispatcher-servlet.xml");
		dao = context.getBean(EmiCardDao.class);
		dao1=context.getBean(UserDao.class);
	}
	
	@Test
	public void addOrUpdateEmiCardTest() {
		EmiCard emiCard = new EmiCard();
		User user=dao1.getUserById(21);
		emiCard.setEmiValidity("2027");
		emiCard.setEmiCardType(CardType.gold.toString());
		emiCard.setEmiCardLimit(250000);
		emiCard.setEmiCardBalance(14500);
		emiCard.setUser(user);
	

		EmiCard savedEmiCard = dao.addOrUpdateEmiCard(emiCard);

		assertNotNull(savedEmiCard);
	}
	
	@Test
	public void getEmiCardByUserId() {
		EmiCard emiCard = dao.getEmiCardByUserId(21);
		assertNotNull(emiCard);
		System.out.println(emiCard.getEmiCardNo());
	}

	
}
