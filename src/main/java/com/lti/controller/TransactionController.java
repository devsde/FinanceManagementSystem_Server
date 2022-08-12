package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.TransactionProductEmiCardDto;
import com.lti.entity.Product;
import com.lti.entity.Transaction;
import com.lti.entity.User;
import com.lti.service.TransactionService;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
//	@RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
//	public Transaction addTransaction(@RequestBody TransactionProductEmiCardDto transactionProductEmiCardDto) {
//		Transaction transaction = transactionProductEmiCardDto.getTransaction();
//		transaction.setProduct(transactionProductEmiCardDto.getProduct());
//		transaction.setEmiCard(transactionProductEmiCardDto.getEmiCard());
//		return transactionService.addOrUpdateTransaction(transaction);
//	}
	
	@RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		return transactionService.addOrUpdateTransaction(transaction);
	}
	
	@RequestMapping(value = "/updateTransaction", method = RequestMethod.PUT)
	public Transaction updateTransaction(@RequestBody Transaction transaction) {
		return transactionService.updateTransaction(transaction);
	}
	
	@GetMapping("/viewAllTransactions/{cardNo}")
	public List<Transaction> viewTransactionsByCardNo(@PathVariable int cardNo){
		return transactionService.viewTransactionsByCardNo(cardNo);
	}
	
	@GetMapping("/getTransaction/{emiCardNo}/{productId}")
	public Transaction getTransaction( @PathVariable int emiCardNo, @PathVariable int productId){
		return transactionService.viewTransactionByCardNoAndProductId(emiCardNo, productId);
	}
	
	@GetMapping("/viewTransactions")
	public List<Transaction> viewTransactionsForAdmin(){
		return transactionService.viewTransactionsForAdmin();
	}
	
}
