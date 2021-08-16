package com.example.model.layer4;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.model.layer2.Accountdetail;
import com.example.model.layer2.Transaction;
import com.example.model.layer3.BaseRepository;

@CrossOrigin
@Service
public class FundTransferServiceImpl extends BaseRepository implements FundTransferService {

	@Autowired
	MailService mailService;
	
	//Transferring the money from one account to another account 
	@Transactional
	public String addTransaction(int toAccNo, int fromAccNo, Transaction tran) {
			EntityManager entityManager = getEntityManager();
			Accountdetail acc = (Accountdetail) entityManager.createQuery("select a from Accountdetail a where a.accountnumber =: toaccNo").setParameter("toaccNo", toAccNo ).getSingleResult();
			Accountdetail acc1 = (Accountdetail) entityManager.createQuery("select ac from Accountdetail ac where ac.accountnumber =: fromAccNo").setParameter("fromAccNo", fromAccNo ).getSingleResult();
			
			//Validation -----> The Balance amount should be greater than the Amount Transfered 
			if(acc1.getCurrentbalance()>=tran.getAmounttransferred()) {
					tran.setAccountto(acc);
					tran.setAccountfrom(acc1);
					entityManager.merge(tran);
					
					//Taking the amount transfered
					int amt = tran.getAmounttransferred();
					System.out.println(toAccNo);
					
					//Also crediting and debiting the amount from the accounts 
					acc.setCurrentbalance(acc.getCurrentbalance()+amt);
					acc1.setCurrentbalance(acc1.getCurrentbalance()-amt);
					
					//Mailing the details of the transaction to the Respective Account Numbers
					String info_deb = "Amount debited from your account.\nAmount -->"+amt+"\nTo Account -->"+acc.getAccountnumber();
                    String info_rec = "Amount credited to your account.\nAmount -->"+amt+"\nFrom Account -->"+acc1.getAccountnumber();
                    mailService.sendMail(info_deb, acc1.getCustomerdetail().getEmail());
                    mailService.sendMail(info_rec, acc.getCustomerdetail().getEmail());
                    
					return "Transaction Inserted";
				}
				
				//If Balance is less than the Amount Transfered 
				else if(acc1.getCurrentbalance()<tran.getAmounttransferred()) {
					return "insufficient funds";
				}
			
				//If the Details is wrong
				else {
					return "Wrong details. Please try again";
				}
	        }
	}