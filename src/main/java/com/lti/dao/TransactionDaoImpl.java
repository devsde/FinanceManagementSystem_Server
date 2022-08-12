package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.entity.EmiCard;
import com.lti.entity.Transaction;
import com.lti.entity.User;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	
	@Autowired
	EmiCardDao emiCardDao;
	
	@PersistenceContext
	EntityManager em;
    
	@Transactional
	public Transaction addOrUpdateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		try {
			transaction.getEmiCard().setEmiCardBalance(transaction.getEmiCard().getEmiCardBalance() - transaction.getPaidAmount());
			Transaction persistedTransaction=em.merge(transaction);
			return persistedTransaction;
		}
		catch(Exception e){
			return null;
		}
		
	}

	public List<Transaction> viewTransactionsByCardNo(int cardNo) {
		
		EmiCard emiCard = emiCardDao.getEmiCardByCardNo(cardNo);
		List<Transaction> transactions = emiCard.getTransactions();
		return transactions;
	}


	public Transaction viewTransactionByCardNoAndProductId(int emiCardNo, int productId) {
		String jpql = "select t from Transaction t where t.emiCard.emiCardNo =: ec and t.product.productId=: pid";
		TypedQuery<Transaction> query = em.createQuery(jpql, Transaction.class);
		query.setParameter("pid", productId);
		query.setParameter("ec", emiCardNo);
		Transaction transaction = query.getSingleResult();
		return transaction;
	}

	public List<Transaction> viewTransactionsForAdmin() {
		String jpql = "select t from Transaction t";
		TypedQuery<Transaction> query = em.createQuery(jpql,Transaction.class);
		return query.getResultList();
	}



}
