package com.example.model.layer3;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.model.layer2.Transaction;



@Repository
public class TransactionRepositoryImpl extends BaseRepository implements TransactionRepository {

	//Show All The Transaction of the Customer who is sending the Money On the bases of Account Number 
	@Override
	public List<Transaction> selectTrans(int accNo) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("from Transaction");
		List<Transaction> TransactionsList = query.getResultList();
		List<Transaction> FinalList = new ArrayList<>();
		for (Transaction transaction : TransactionsList) {
			if(transaction.getAccountto().getAccountnumber()==accNo || transaction.getAccountfrom().getAccountnumber()==accNo) {
				FinalList.add(transaction);
			}
		}
		return FinalList;
	}
	
	//Show All The Transaction Occurred in The Bank (Checking Purpose)
	@Override
	public List<Transaction> selectAllTransactions() {
		System.out.println("AccountRepository : Layer 3");
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("from Transaction");
		List<Transaction> TransactionsList = query.getResultList();
		return TransactionsList;
	}

}