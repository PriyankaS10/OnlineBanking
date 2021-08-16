package com.example.model.layer4;

import org.springframework.stereotype.Service;

@Service
public interface SetNewPasswordService {
	//boolean LoginPassword(String loginpassword);

	void updatePassword(String loginpassword, int accountnumber);
	
	}