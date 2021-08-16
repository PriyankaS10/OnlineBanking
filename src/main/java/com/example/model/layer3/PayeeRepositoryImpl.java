package com.example.model.layer3;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.model.layer2.Accountdetail;
import com.example.model.layer2.Payee;
import com.example.model.layer2.Exception.PayeeNotFoundException;

@Repository
public class PayeeRepositoryImpl extends BaseRepository implements PayeeRepository {

		//Adding a New Beneficiary Account of An Existing Customer 
	    @Transactional
	    public void insertPayee(int accNo,Payee ref) {
	        EntityManager entityManager = getEntityManager();
	        Accountdetail acc = (Accountdetail) entityManager.createQuery("select a from Accountdetail a where a.accountnumber =: accNo").setParameter("accNo", accNo).getSingleResult();
	        ref.setAccountdetail(acc);
	        entityManager.merge(ref);
	        System.out.println("Payee inserted..."+ref);
	    }
	 
	    
	    //Showing All The Beneficiaries of A Particular Account or Existing Customer
	    @Override
	    public List<Payee> selectPayee(int AccNo) throws PayeeNotFoundException {
	    	Query query = entityManager.createQuery("from Payee");
	        List<Payee> PayeeList = query.getResultList();
	        List<Payee> FinalList = new ArrayList<>();
	        for (Payee payee : PayeeList) {
	        	if(payee.getAccountdetail().getAccountnumber()==AccNo) {
	        		FinalList.add(payee);
	        	}
			}
	        return FinalList;
	    }
	    
	    
	    //Showing All The Payees Of The Bank (Checking Purpose)
	    @Transactional
	    public List<Payee> selectAllPayee() {
	        System.out.println("PayeeRepository : Layer 3");
	        EntityManager entityManager = getEntityManager();
	        Query query = entityManager.createQuery("from Payee");
	        List<Payee> PayeeList = query.getResultList();
	        return PayeeList;
	    }

	    
	    //Deleting Beneficiary of A Particular Customer on the bases of Beneficiary Id
	    @Transactional
	    public void deletePayee(int BeneficiaryId) throws PayeeNotFoundException {
	        EntityManager entityManager = getEntityManager();
	        Payee foundPayee = entityManager.find(Payee.class, BeneficiaryId);
	        if(foundPayee!=null)
	        	entityManager.remove(foundPayee);
	        else
	            throw new PayeeNotFoundException("Payee Not Found : "+BeneficiaryId);
	        System.out.println("Payee removed ... ");
	    }

}
