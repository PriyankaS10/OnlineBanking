package com.example.model;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.layer2.Accountdetail;
import com.example.model.layer2.Customerdetail;
import com.example.model.layer2.Payee;
import com.example.model.layer2.Transaction;
import com.example.model.layer2.Exception.CustomerNotFoundException;
import com.example.model.layer2.Exception.PayeeNotFoundException;
import com.example.model.layer3.AccountRepositoryImpl;
import com.example.model.layer3.CustomerReositoryImpl;
import com.example.model.layer3.PayeeRepositoryImpl;
import com.example.model.layer3.TransactionRepositoryImpl;
import com.example.model.layer4.LoginServiceImpl;

@SpringBootTest
public class PayeeTest {
	
	@Autowired
	PayeeRepositoryImpl payeeRepositor;
	@Autowired
	AccountRepositoryImpl accountrepositoryIMPL;
	@Autowired
	CustomerReositoryImpl custRepIMPL;
	@Autowired
	TransactionRepositoryImpl transactionRepositioryIMPL;

	
	//Show All Payees
	@Test
	public void showAllPayees() {
		List<Payee> allPayees = payeeRepositor.selectAllPayee();
		for(Payee p : allPayees) {
			System.out.println("ID :"+p.getBeneficiaryid());
			System.out.println("Account Number :"+p.getAccountdetail().getAccountnumber());
			System.out.println("Benificiary AccountNumber :"+p.getBaccountnumber());
			System.out.println("Benificiary Name :"+p.getBeneficiaryname());
			System.out.println("Nickname :"+p.getNickname());
			
       }
	}

	//Show Single Payee
	@Test
	public void showSinglePayeeTest() throws PayeeNotFoundException {
        List<Payee> payee = payeeRepositor.selectPayee(10002);
        for(Payee p:payee) {
        	System.out.println("ID :"+p.getBeneficiaryid());
			System.out.println("Benificiary AccountNumber :"+p.getBaccountnumber());
			System.out.println("Benificiary Name :"+p.getBeneficiaryname());
			System.out.println("Nickname :"+p.getNickname());
        }
	}
	
	
	//Insert Single Payee
	@Test
	public void insertSinglePayeeTest() {
		Accountdetail accountdetail = null;
		Payee payee = new Payee(10010, "Pratik", null, accountdetail);
        payeeRepositor.insertPayee(10010, payee);
        List<Payee> allPayee = payeeRepositor.selectAllPayee();
        for(Payee p : allPayee) {
			System.out.println("ID :"+p.getBeneficiaryid());
			System.out.println("Account Number :"+p.getAccountdetail().getAccountnumber());
			System.out.println("Benificiary AccountNumber :"+p.getBaccountnumber());
			System.out.println("Benificiary Name :"+p.getBeneficiaryname());
			System.out.println("Nickname :"+p.getNickname());
       }
	}
	
	
	//Show Single Customer
	@Test
	public void showSingleCustomer() throws CustomerNotFoundException {
		Customerdetail customerdetails = custRepIMPL.selectCustomer(109);
        	System.out.println("ID :"+ customerdetails.getCustid());
        	System.out.println("AadharCard Number :"+ customerdetails.getAadharnumber());
        	System.out.println("City :"+ customerdetails.getCity());
        	System.out.println("DebitCard :"+ customerdetails.getDebitcard());
        	System.out.println("Email :"+ customerdetails.getEmail());
        	System.out.println("FatherName :"+ customerdetails.getFathername());
        	System.out.println("FirstName :"+ customerdetails.getFirstname());
        	System.out.println("Grossannualincome :"+ customerdetails.getGrossannualincome());
        	System.out.println("Incomesource :"+ customerdetails.getIncomesource());
        	System.out.println("Landmark :"+ customerdetails.getLandmark());
        	System.out.println("Lastname :"+ customerdetails.getLastname());
        	System.out.println("Line1 :"+ customerdetails.getLine1());
        	System.out.println("Line2 :"+ customerdetails.getLine2());
        	System.out.println("Middlename :"+ customerdetails.getMiddlename());
        	System.out.println("Mobilenumber :"+ customerdetails.getMobilenumber());
        	System.out.println("Occupationtype :"+ customerdetails.getOccupationtype());
        	System.out.println("Optnetbanking :"+ customerdetails.getOptnetbanking());
        	System.out.println("State :"+ customerdetails.getState());
        	System.out.println("Title :"+ customerdetails.getTitle());
        	System.out.println("Dob :"+ customerdetails.getDob());
        	System.out.println("Pincode :"+ customerdetails.getPincode());
	}
	
	
	//Show All Customer
	@Test
	public void showAllCustomer() throws CustomerNotFoundException {
		List<Customerdetail> customers = custRepIMPL.selectAllCustomers();       
    	for(Customerdetail customerdetails:customers) {
        	System.out.println("ID :"+ customerdetails.getCustid());
        	System.out.println("AadharCard Number :"+ customerdetails.getAadharnumber());
        	System.out.println("City :"+ customerdetails.getCity());
        	System.out.println("DebitCard :"+ customerdetails.getDebitcard());
        	System.out.println("Email :"+ customerdetails.getEmail());
        	System.out.println("FatherName :"+ customerdetails.getFathername());
        	System.out.println("FirstName :"+ customerdetails.getFirstname());
        	System.out.println("Grossannualincome :"+ customerdetails.getGrossannualincome());
        	System.out.println("Incomesource :"+ customerdetails.getIncomesource());
        	System.out.println("Landmark :"+ customerdetails.getLandmark());
        	System.out.println("Lastname :"+ customerdetails.getLastname());
        	System.out.println("Line1 :"+ customerdetails.getLine1());
        	System.out.println("Line2 :"+ customerdetails.getLine2());
        	System.out.println("Middlename :"+ customerdetails.getMiddlename());
        	System.out.println("Mobilenumber :"+ customerdetails.getMobilenumber());
        	System.out.println("Occupationtype :"+ customerdetails.getOccupationtype());
        	System.out.println("Optnetbanking :"+ customerdetails.getOptnetbanking());
        	System.out.println("State :"+ customerdetails.getState());
        	System.out.println("Title :"+ customerdetails.getTitle());
        	System.out.println("Dob :"+ customerdetails.getDob());
        	System.out.println("Pincode :"+ customerdetails.getPincode());

	}
	
}
	
	//Insert Single Customer
	@Test
	public void insertSingleCustomerTest() throws CustomerNotFoundException {
		Customerdetail customerdetail = new Customerdetail("Y", null, "raghu@vyas", "Manoj", "Raghu", "123400", "Salary", 10000, "Gupta",null, "9082726427", "Service","Y","Mumbai","Croma","Shanti App","S.V.Road", 4000092,"Maharashtra","Miss",123654);
        custRepIMPL.insertCustomer(customerdetail);
        System.out.println("Customer Inserted");
        //System.out.println("dept is "+dept);
        Customerdetail customerdetails = custRepIMPL.selectCustomer(customerdetail.getCustid());
    	System.out.println("ID :"+ customerdetails.getCustid());
    	System.out.println("AadharCard Number :"+ customerdetails.getAadharnumber());
    	System.out.println("City :"+ customerdetails.getCity());
    	System.out.println("DebitCard :"+ customerdetails.getDebitcard());
    	System.out.println("Email :"+ customerdetails.getEmail());
    	System.out.println("FatherName :"+ customerdetails.getFathername());
    	System.out.println("FirstName :"+ customerdetails.getFirstname());
    	System.out.println("Grossannualincome :"+ customerdetails.getGrossannualincome());
    	System.out.println("Incomesource :"+ customerdetails.getIncomesource());
    	System.out.println("Landmark :"+ customerdetails.getLandmark());
    	System.out.println("Lastname :"+ customerdetails.getLastname());
    	System.out.println("Line1 :"+ customerdetails.getLine1());
    	System.out.println("Line2 :"+ customerdetails.getLine2());
    	System.out.println("Middlename :"+ customerdetails.getMiddlename());
    	System.out.println("Mobilenumber :"+ customerdetails.getMobilenumber());
    	System.out.println("Occupationtype :"+ customerdetails.getOccupationtype());
    	System.out.println("Optnetbanking :"+ customerdetails.getOptnetbanking());
    	System.out.println("State :"+ customerdetails.getState());
    	System.out.println("Title :"+ customerdetails.getTitle());
    	System.out.println("Dob :"+ customerdetails.getDob());
    	System.out.println("Pincode :"+ customerdetails.getPincode());
     }
	
	
	//Show Single Account 
	@Test
	public void showSingleAccountTest() throws AccountNotFoundException {
        List<Accountdetail> account = accountrepositoryIMPL.selectAccOnAccno(10002);        
        	for(Accountdetail a:account) {
        	System.out.println("Custid :"+a.getCid());
        	System.out.println("Account No :"+a.getAccountnumber());
        	System.out.println("User ID :"+a.getUserid()); 
        	System.out.println("Account Locked :"+a.getAccountlock());
        	System.out.println("Account Status :"+a.getAccountstatus());
        	System.out.println("Account Created ON :"+a.getCreatedon());
        	System.out.println("Transactional Password :"+a.getTransactionpassword());
        	System.out.println("Login Password :"+a.getLoginpassword());
        	System.out.println("Account Type :"+a.getAccounttype());
        	System.out.println("Current Balance :"+a.getCurrentbalance());
        	System.out.println("Customer Id :"+a.getCustomerdetail().getCustid());
			
        	}
		}

	
	//Insert Single Account
	@Test
	public void insertSingleAccountTest() throws AccountNotFoundException {
		Customerdetail customerdetail=null;
		Accountdetail accountdetail=new Accountdetail("Savings", 15000, "Abcd@gmail.com", "T20", customerdetail);
       accountrepositoryIMPL.insertAccount(90, accountdetail);
        List<Accountdetail> accountdetails = accountrepositoryIMPL.selectAccOnAccno(accountdetail.getAccountnumber());
        for(Accountdetail a : accountdetails) {
			System.out.println("AccountNumber :"+ a.getAccountnumber());
			System.out.println("Account Locked :"+a.getAccountlock());
			System.out.println("Account Status :"+a.getAccountstatus());
			System.out.println("Account Type :"+a.getAccounttype());
			System.out.println("Cust ID :"+a.getCid());
			System.out.println("Current Balance :"+a.getCurrentbalance());
			System.out.println("Customer Id :"+a.getCustId());
			System.out.println("Login Password :"+a.getLoginpassword());
			System.out.println("Transaction Password :"+a.getTransactionpassword());
			System.out.println("User ID :"+a.getUserid());
			System.out.println("Account Creation :"+a.getCreatedon());
       }
	}
	
	//Show Single Transaction
	@Test
	public void showSingleTransactionTest() {
        List<Transaction> transaction = transactionRepositioryIMPL.selectTrans(10005);        
        	for(Transaction t:transaction) {
        	System.out.println("Transactionid :"+t.getTransactionid());
        	System.out.println("Account Transferred :"+t.getAmounttransferred());
        	System.out.println("Mode of Transaction :"+t.getModeoftransaction());
        	System.out.println("Remarks :"+t.getRemarks());
        	System.out.println("Transaction Date :"+t.getTransactiondate());
        	System.out.println("From Account :"+t.getToAccountNumber());
        	System.out.println("To Account :"+t.getFromAccountNumber());
        	
			
        	}
		}
	
	
	//Show All Transaction
	@Test
	public void showAllTransactionTest() {
        List<Transaction> transactions = transactionRepositioryIMPL.selectAllTransactions();        
        	for(Transaction t:transactions) {
        	System.out.println("Transactionid :"+t.getTransactionid());
        	System.out.println("Account Transferred :"+t.getAmounttransferred());
        	System.out.println("Mode of Transaction :"+t.getModeoftransaction());
        	System.out.println("Remarks :"+t.getRemarks());
        	System.out.println("Transaction Date :"+t.getTransactiondate());
        	System.out.println("From Account :"+t.getToAccountNumber());
        	System.out.println("To Account :"+t.getFromAccountNumber());
        	
			
        	}
		}
	
}
