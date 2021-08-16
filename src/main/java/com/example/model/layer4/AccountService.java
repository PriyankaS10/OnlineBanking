package com.example.model.layer4;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.model.layer2.Accountdetail;

@Service
public interface AccountService {
	void insertAccountService(int custId , Accountdetail ref);
	Accountdetail selectAccService(int cid);
	List<Accountdetail> selectAccOnAccnoService(int accno);

}
