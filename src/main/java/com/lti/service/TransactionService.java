package com.lti.service;

import java.util.List;

import com.lti.entity.Transaction;

public interface TransactionService {
	Transaction addOrUpdateTransaction(Transaction transaction);
	Transaction updateTransaction(Transaction transaction);
	List<Transaction> viewTransactionsByCardNo(int cardNo);
	Transaction viewTransactionByCardNoAndProductId(int emiCardNo, int productId);
	List<Transaction> viewTransactionsForAdmin();
}
