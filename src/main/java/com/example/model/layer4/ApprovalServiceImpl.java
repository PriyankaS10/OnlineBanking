package com.example.model.layer4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.model.layer2.Accountdetail;
import com.example.model.layer2.Admin;
import com.example.model.layer2.Approval;
import com.example.model.layer2.Customerdetail;
import com.example.model.layer3.BaseRepository;

@CrossOrigin
@Service
public class ApprovalServiceImpl extends BaseRepository implements ApprovalService {
	
	@Autowired
	MailService mailService;

	//Listing All the Account Details of the New Customer to the Admin to verify the Customer Details and approve the Same
	@Override
	public List<Accountdetail> accToVerify() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select a from Accountdetail a where a.accountstatus='N'");
		List<Accountdetail> listacc = query.getResultList();
		return listacc;
	}

	
	//Verification is Done (Admin have Approved the Customer) and the status of the account is set to YES
	@Transactional
	public void approveAccount(int custId) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("UPDATE Accountdetail SET accountstatus = 'Y' Where custid=: custid");
		int updateCount = query.setParameter("custid",custId).executeUpdate();
		System.out.println("Account approved");
	}

	
	//Approval is added to the approval table and called the approve Account Method 
	@Transactional
	public void addApproval(int custId,Approval app,int adminId) {
		approveAccount(custId);
		EntityManager entityManager = getEntityManager();
		Customerdetail cd = (Customerdetail) entityManager.createQuery("select c from Customerdetail c where c.custid =: cust").setParameter("cust", custId).getSingleResult();
        Admin admin = (Admin) entityManager.createQuery("select ad from Admin ad where ad.adminid =: adminId").setParameter("adminId", adminId).getSingleResult();
		app.setCustomerdetail(cd);
        app.setAdmin(admin);
        entityManager.persist(app);
        
      //The Email is sent to the Customers Email Address saying that the Account is verified with the details of the Customer
        String info = "Hi your account is created CustId --> "+cd.getCustid()+"\nAccount Number -->"+cd.getAccountdetail().getAccountnumber()+"\nUser Id for NB --> "+cd.getAccountdetail().getUserid()+"\nlogin Pass --> "+cd.getAccountdetail().getLoginpassword()+"\nTHANKYOU FOR BANKING WITH US!!";
        mailService.sendMail(info, cd.getEmail());
	}

}
