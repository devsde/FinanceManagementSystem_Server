package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.EmiCard;
import com.lti.entity.User;

@Repository
public class EmiCardDaoImpl implements EmiCardDao {

	@Autowired
	UserDao userDao;
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public EmiCard addOrUpdateEmiCard(EmiCard emiCard) {
		EmiCard emiCardPersisted=null;
		try {
			emiCardPersisted=em.merge(emiCard);
			return emiCardPersisted;
		} catch (Exception e) {
			return null;
		}
	}
	
	public EmiCard getEmiCardByUserId(int userId) {
		
		User user = userDao.getUserById(userId);
		EmiCard emiCard = user.getEmiCard();
		System.out.println(emiCard.getEmiCardNo());
		return emiCard;
		
//		try {
//			String jpql="select e from EmiCard e join User u where e.userId = u.userId";
//			TypedQuery<EmiCard> query = em.createQuery(jpql, EmiCard.class);
//			query.setParameter("userId", userId);
//			System.out.println();
//			EmiCard ec =  query.getSingleResult();
//			System.out.println(ec);
//			return ec;
//		} catch (Exception e) {
//			System.out.println("inside");
//			return null;
//		}

	}

	public EmiCard getEmiCardByCardNo(int emiCardNo) {
		return em.find(EmiCard.class, emiCardNo);
	}

}
