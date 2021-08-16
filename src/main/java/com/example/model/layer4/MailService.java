package com.example.model.layer4;

import org.springframework.stereotype.Service;

@Service
public interface MailService {
	public void employeeRegistration(String registeredUser, String registeredUserEmail);
		
	public void sendMail(String info,String email);
}
