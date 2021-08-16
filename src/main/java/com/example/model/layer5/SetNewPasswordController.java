package com.example.model.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.layer4.SetNewPasswordServiceImpl;

@CrossOrigin(origins="*")
@Controller
@RequestMapping(value = "/setPass")
public class SetNewPasswordController {
	
	@Autowired
	SetNewPasswordServiceImpl setNewPasswordServiceImpl;
	
	
	public SetNewPasswordController() {
		System.out.println("SetNewpasswordJPAController() Created");
	}
	
	//Set New Password
	@PutMapping
	@ResponseBody
	@RequestMapping(value = "/login/{LoginPassword}/{AccountNumber}")
	public void checkLogin(@PathVariable String LoginPassword, @PathVariable int AccountNumber) {
	   
		 setNewPasswordServiceImpl.updatePassword(LoginPassword, AccountNumber);

	
}
}