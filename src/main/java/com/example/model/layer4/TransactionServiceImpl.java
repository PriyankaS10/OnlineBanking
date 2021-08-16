package com.example.model.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.model.layer2.Transaction;
import com.example.model.layer3.TransactionRepositoryImpl;

@CrossOrigin
@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionRepositoryImpl transactionRepositioryIMPL;
	
	@Override
	public List<Transaction> selectTransService(int accNo) {
		return transactionRepositioryIMPL.selectTrans(accNo);
	}

	@Override
	public List<Transaction> selectAllTransactionsService() {
		return transactionRepositioryIMPL.selectAllTransactions();
	}

//	@Override
//	public void insertTransService(Transaction ref) {
//		transactionRepositioryIMPL.insertTrans(ref);
//	}
	

}
