package com.example.model.layer4;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.model.layer2.Customerdetail;
import com.example.model.layer2.Exception.CustomerNotFoundException;
import com.example.model.layer3.CustomerReositoryImpl;

@CrossOrigin
@Service
public class CustomerDetailsServiceIMPL implements CustomerDetailsService {
	
	@Autowired
	CustomerReositoryImpl custRepIMPL;
	
	@Transactional
	public List<Customerdetail> getAllCustService() {
		return custRepIMPL.selectAllCustomers();
	}

	@Transactional
	public Customerdetail addCustomerService(Customerdetail cust ) {
		return custRepIMPL.insertCustomer(cust);
	}
	
	public Customerdetail selectCustomerService(int Custid) {
		try {
			return custRepIMPL.selectCustomer(Custid);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
