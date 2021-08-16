package com.example.model.layer4;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.model.layer2.Accountdetail;
import com.example.model.layer3.AccountRepositoryImpl;

@CrossOrigin
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepositoryImpl accountrepositoryIMPL;

	//Adding of Account 
	@Override
	public void insertAccountService(int custId, Accountdetail ref) {
		accountrepositoryIMPL.insertAccount(custId, ref);
	}
	
	//Show the Account Details on the bases of cid
	@Override
	public Accountdetail selectAccService(int cid) {
		return accountrepositoryIMPL.selectAcc(cid);
	}

	//Show the Account Details on the bases of Account Number
	@Override
	public List<Accountdetail> selectAccOnAccnoService(int accno) {
		try {
			return accountrepositoryIMPL.selectAccOnAccno(accno);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
