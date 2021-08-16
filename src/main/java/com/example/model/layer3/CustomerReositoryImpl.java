package com.example.model.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.model.layer2.Customerdetail;
import com.example.model.layer2.Exception.CustomerNotFoundException;

@Repository
public class CustomerReositoryImpl extends BaseRepository implements CustomerRepository{
	
	//Adding of new Customer in the Bank 
	@Transactional
	public Customerdetail insertCustomer(Customerdetail cust) {
		EntityManager entityManager = getEntityManager();
		entityManager.persist(cust);
		System.out.println("Customer inserted...");
		return cust;
	}

	//Showing the Customer On bases of Customer ID
	@Override
	public Customerdetail selectCustomer(int CustId) throws CustomerNotFoundException {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Customerdetail.class, CustId);
	}

	//Showing All the Customers of the Bank
	@Override
	public List<Customerdetail> selectAllCustomers() {
		System.out.println("customerRepository : Layer 3");
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("from Customerdetail");
		List<Customerdetail> CustomerDetailsList = query.getResultList();
		return CustomerDetailsList;
	}

}
