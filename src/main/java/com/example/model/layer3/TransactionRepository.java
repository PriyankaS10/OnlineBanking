package com.example.model.layer3;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.model.layer2.Transaction;

@Repository
public interface TransactionRepository {

	List<Transaction> selectTrans(int accNo);
	List<Transaction> selectAllTransactions();

}
