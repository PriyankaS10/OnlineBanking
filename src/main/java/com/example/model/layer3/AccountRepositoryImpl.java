package com.example.model.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.model.layer2.Accountdetail;
import com.example.model.layer2.Customerdetail;


import java.util.ArrayList;


@Repository
public class AccountRepositoryImpl extends BaseRepository implements AccountRepository{

	//Adding the Account Details of the new Customers
    @Transactional
    public void insertAccount(int custId , Accountdetail ref) {
        EntityManager entityManager = getEntityManager();
        Customerdetail cd = (Customerdetail) entityManager.createQuery("select c from Customerdetail c where c.custid =: custId").setParameter("custId", custId).getSingleResult();
        ref.setCustomerdetail(cd);
        entityManager.merge(ref);
        System.out.println("Account inserted..."+ref);
    }

 
    //Showing the Account on the bases of cid which is the primary key of Accountdetails Table
    @Override
    public Accountdetail selectAcc(int cid)  {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Accountdetail.class, cid);
    }
    
    
    
    //Showing the Account on the bases AccountNumber of  which is the primary key of Accountdetails Table
    @Override
    public List<Accountdetail> selectAccOnAccno(int accno) throws AccountNotFoundException  { 
    	EntityManager entityManager = getEntityManager();
    	Query query = entityManager.createQuery("from Accountdetail");
        List<Accountdetail> AccountDetailsList = query.getResultList();
        List<Accountdetail> FinalList = new ArrayList<>();
        
        for (Accountdetail accountdetail : AccountDetailsList) {
            if(accountdetail.getAccountnumber() ==accno) {
                FinalList.add(accountdetail);
            }
        }
        return FinalList;
    }
   
    
}