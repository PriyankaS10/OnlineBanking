package com.example.model.layer3;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.layer2.Customerdetail;
import com.example.model.layer2.Exception.CustomerNotFoundException;


@Repository
public interface CustomerRepository {
	
	Customerdetail insertCustomer(Customerdetail cust);
	Customerdetail selectCustomer(int CustId) throws CustomerNotFoundException;
	List<Customerdetail> selectAllCustomers();

}