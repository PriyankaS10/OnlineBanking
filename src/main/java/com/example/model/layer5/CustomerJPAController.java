package com.example.model.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.layer2.Customerdetail;
import com.example.model.layer4.CustomerDetailsServiceIMPL;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/customer")
public class CustomerJPAController {
	
	@Autowired
	CustomerDetailsServiceIMPL CustDetService;
	
	public CustomerJPAController() {
		System.out.println("CustomerJPAController() Created");
	}
	
	//Get Customer On the bases of Customer Id
	//Takes custId and then returns a customer corresponding to it
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getCustomer/{CustId}")
	public Customerdetail getCustomer(@PathVariable int CustId) {
		System.out.println("getEmployee()...method ");
		return CustDetService.selectCustomerService(CustId);
	}
	
	
	//Returns all customers
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getAllCustomers")
	public List<Customerdetail> getAllCustomers(){
		return CustDetService.getAllCustService();
	}

	
	//Adds a customer
	@PostMapping
	@ResponseBody
	@RequestMapping(value="/addCust", consumes="application/json")
	public Customerdetail addCustomerService(@RequestBody Customerdetail cust) {
		System.out.println("addCustomer(@RequestBody emp)...method ");
		return CustDetService.addCustomerService(cust);
	}
	 
}
	
	