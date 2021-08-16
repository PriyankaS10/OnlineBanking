package com.example.model.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.layer2.Payee;
import com.example.model.layer2.Exception.PayeeNotFoundException;

@Service
public interface PayeeService {
	void insertPayeeService(int accNo,Payee ref);
    List<Payee> selectPayeeService(int AccNo);
    List<Payee> selectAllPayeeService();
 
    void deletePayeeService(int BeneficiaryId);

	
}
