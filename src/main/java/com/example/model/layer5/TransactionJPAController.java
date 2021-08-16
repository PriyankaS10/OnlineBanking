package com.example.model.layer5;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.model.layer2.Transaction;
import com.example.model.layer4.TransactionServiceImpl;

@CrossOrigin(origins="*")
@Controller
@RequestMapping(value = "/transaction")
public class TransactionJPAController {
	@Autowired
	TransactionServiceImpl transactionServiceIMPL;

	public TransactionJPAController() {
		System.out.println("TransactionJPAController() Created");
	}

	//Get All Transaction on the bases of Account Number
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getTrans/{accNo}")
	public List<Transaction> selectTrans(@PathVariable int accNo) {
		System.out.println("getTransaction()...method ");
		return transactionServiceIMPL.selectTransService(accNo);
	}

	//Get all Transaction done in the Bank 
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getAllTrans")
	public List<Transaction> getAllTransactions() {
		System.out.println("geting all Transactions...layer5");
		return transactionServiceIMPL.selectAllTransactionsService();
	}

}