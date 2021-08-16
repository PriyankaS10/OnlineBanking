package com.example.model.layer4;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.model.layer2.Payee;
import com.example.model.layer2.Exception.PayeeNotFoundException;
import com.example.model.layer3.PayeeRepositoryImpl;

@CrossOrigin
@Service
public class PayeeServiceImpl implements PayeeService {
	
	@Autowired
	PayeeRepositoryImpl payeeRepositoryIMPL;
	
	
	@Transactional
	public void insertPayeeService(int accNo, Payee ref) {
		payeeRepositoryIMPL.insertPayee(accNo,ref);
	}
	
	

	@Override
	public List<Payee> selectPayeeService(int AccNo){
		try {
			return payeeRepositoryIMPL.selectPayee(AccNo);
		} catch (PayeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public List<Payee> selectAllPayeeService() {
		return payeeRepositoryIMPL.selectAllPayee();
	}
	
	

	@Override
	public void deletePayeeService(int BeneficiaryId){
		try {
			payeeRepositoryIMPL.deletePayee(BeneficiaryId);
		} catch (PayeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
