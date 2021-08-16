package com.example.model.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.layer2.Accountdetail;
import com.example.model.layer2.Approval;
import com.example.model.layer2.Customerdetail;
import com.example.model.layer4.ApprovalServiceImpl;
import com.example.model.layer4.MailService;

@CrossOrigin(origins="*")
@Controller
@RequestMapping(value ="/approval")
public class ApprovalController {
	
	@Autowired
	ApprovalServiceImpl approvalServiceIMPL;
	
	public ApprovalController() {
		System.out.println("ApprovalJPAController");
	}
	
	//Accounts To Approve 
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/accToApprove", method = RequestMethod.GET)
	public List<Accountdetail> viewAccToVerify(){
		return approvalServiceIMPL.accToVerify();
	}
	
	//Approving of the Account
	@PostMapping
	@ResponseBody
	@RequestMapping(value="/approveAccount/{custId}/{adminId}",consumes="application/json")
	public void approveAccount(@PathVariable int custId,@PathVariable int adminId, @RequestBody Approval approval) {
		approvalServiceIMPL.addApproval(custId, approval, adminId);
	}
}
