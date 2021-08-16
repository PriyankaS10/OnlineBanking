package com.example.model.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.model.layer2.Transaction;
import com.example.model.layer4.FundTransferServiceImpl;

@CrossOrigin(origins="*")
@Controller
@RequestMapping(value ="/transfer")
public class FundTransferController {
	
	@Autowired
	FundTransferServiceImpl fundTransferServiceImpl; 
	
	
	public FundTransferController() {
		System.out.println("FundTransferController");
	}

	
	//Transferring of Money
	@PostMapping
	@ResponseBody
	@RequestMapping(value = "/addFund/{toAccNo}/{fromAccNo}", consumes="application/json")
	public void addTransaction(@PathVariable int toAccNo ,@PathVariable int fromAccNo, @RequestBody Transaction tran) {
		System.out.println("addPayee()...method ");
		fundTransferServiceImpl.addTransaction(toAccNo, fromAccNo, tran);
	}

}
