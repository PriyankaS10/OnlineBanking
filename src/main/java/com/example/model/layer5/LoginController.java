package com.example.model.layer5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.layer2.Accountdetail;
import com.example.model.layer2.Admin;
import com.example.model.layer4.LoginServiceImpl;

@CrossOrigin(origins="*")
@Controller
@RequestMapping(value = "/loginpage")
public class LoginController {
@Autowired
LoginServiceImpl loginServiceIMPL;

public LoginController() {
System.out.println("LoginJPAController() Created");
}

//Customer Login
@GetMapping
@ResponseBody
@RequestMapping(value = "/login/{userId}/{pass}", method = RequestMethod.GET)
public Accountdetail checkCustomerLogin(@PathVariable String userId, @PathVariable String pass) {
return loginServiceIMPL.customerLogin(userId,pass);
 }

//Admin Login
@GetMapping
@ResponseBody
@RequestMapping(value = "/admin/{adminId}/{pass}", method = RequestMethod.GET)
public Admin checkAdminLogin(@PathVariable long adminId, @PathVariable String pass) {
return loginServiceIMPL.adminLogin(adminId,pass);

 }
}