package com.example.model.layer4;



import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.model.layer3.BaseRepository;


@CrossOrigin
@Service
public class SetNewPasswordServiceImpl extends BaseRepository implements SetNewPasswordService {

		//Setting The New Password for an Existing Customer
	    @Transactional
	    public void updatePassword(String loginpassword,int accountnumber){
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("UPDATE Accountdetail SET loginpassword =:loginpassword Where accountnumber=: accountnumber");
		int updateCount = query.setParameter("loginpassword",loginpassword).setParameter("accountnumber",accountnumber).executeUpdate();
		 System.out.println ("Successfully updated");
		
	}
}
