package com.example.model.layer3;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.stereotype.Repository;
import com.example.model.layer2.Accountdetail;


@Repository
public interface AccountRepository {

	void insertAccount(int custId , Accountdetail ref);
	Accountdetail selectAcc(int cid);
	List<Accountdetail> selectAccOnAccno(int accno) throws AccountNotFoundException;

}
