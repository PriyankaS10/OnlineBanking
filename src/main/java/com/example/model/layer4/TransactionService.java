package com.example.model.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.layer2.Transaction;

@Service
public interface TransactionService {
	
	List<Transaction> selectTransService(int accNo);
	List<Transaction> selectAllTransactionsService();
//	void insertTransService(Transaction ref);
	
}

