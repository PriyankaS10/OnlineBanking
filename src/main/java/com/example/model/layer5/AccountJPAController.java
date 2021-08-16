package com.example.model.layer5;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.layer2.Accountdetail;
import com.example.model.layer4.AccountServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/account")
public class AccountJPAController {

	@Autowired
	AccountServiceImpl accountServiceIMPL;

	public AccountJPAController() {
		System.out.println("AccountJPAController() Created");
	}
	
	//Get Account On the bases of CID
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getAccount/{cid}")
	public Accountdetail selectAcc(@PathVariable int cid) {
		System.out.println("getAccount()...method ");
		return accountServiceIMPL.selectAccService(cid);
	}

	//Get Account on the bases of Account Number
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getAccountOnAccno/{accno}")
	public List<Accountdetail> selectAccOnAccno(@PathVariable int accno) throws AccountNotFoundException {
		System.out.println("getAccount()...method ");
		return accountServiceIMPL.selectAccOnAccnoService(accno);
	}

	//Adding Account On bases of Customer ID 
	@PostMapping
	@ResponseBody
	@RequestMapping(value = "/addAccount/{custId}", consumes="application/json")
	public void addAccount(@PathVariable int custId , @RequestBody Accountdetail ref) {
		System.out.println("addPayee()...method ");
		accountServiceIMPL.insertAccountService(custId, ref);
	}

}