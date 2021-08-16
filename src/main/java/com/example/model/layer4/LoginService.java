package com.example.model.layer4;

import org.springframework.stereotype.Service;



import com.example.model.layer2.Accountdetail;
import com.example.model.layer2.Admin;

 


@Service
public interface LoginService{
        
           Accountdetail customerLogin(String userId, String pass);
           Admin adminLogin(long adminId,String pass);
    
}