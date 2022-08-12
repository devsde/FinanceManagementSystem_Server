package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.TransactionDao;
import com.lti.entity.Transaction;

@Component
public class TransactionServiceimpl implements TransactionService {
	@Autowired
	TransactionDao transactionDao;

	public Transaction addOrUpdateTransaction(Transaction transaction) {
		try {
			Transaction updatedtransaction= transactionDao.addOrUpdateTransaction(transaction);
			return updatedtransaction;
			}
			catch(Exception e) {
				return null;
			}
	}
	
	public Transaction updateTransaction(Transaction transaction) {
		return transactionDao.addOrUpdateTransaction(transaction);
		

	}


	public List<Transaction> viewTransactionsByCardNo(int cardNo) {
		return transactionDao.viewTransactionsByCardNo(cardNo);
	}

	public Transaction viewTransactionByCardNoAndProductId(int emiCardNo, int productId) {
		return transactionDao.viewTransactionByCardNoAndProductId(emiCardNo,productId);
	}


	public List<Transaction> viewTransactionsForAdmin() {
		return transactionDao.viewTransactionsForAdmin();
	}

}
