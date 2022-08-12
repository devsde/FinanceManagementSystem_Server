package com.lti.dao;

import java.util.List;

import com.lti.entity.Transaction;

public interface TransactionDao {
	
	Transaction addOrUpdateTransaction(Transaction transaction);
	List<Transaction> viewTransactionsByCardNo(int cardNo);
	Transaction viewTransactionByCardNoAndProductId(int emiCardNo, int productId);
	List<Transaction> viewTransactionsForAdmin();
}
