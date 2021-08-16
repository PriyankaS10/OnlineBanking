package com.example.model.layer3;
 
import java.util.List;
 
import com.example.model.layer2.Payee;
import com.example.model.layer2.Exception.PayeeNotFoundException;
 
public interface PayeeRepository {


    void insertPayee(int accNo,Payee ref);
    List<Payee> selectPayee(int AccNo) throws PayeeNotFoundException;
    List<Payee> selectAllPayee();
    void deletePayee(int BeneficiaryId) throws PayeeNotFoundException;

 
}