package com.example.model.layer2;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

//This is the pojo of Admin which we are taking from the oracle

@Entity
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int adminid;

	private String adminpassword;

	//bi-directional many-to-one association to Approval
	@OneToMany(mappedBy="admin",cascade=CascadeType.ALL)
	List<Approval> approvals;

	public Admin(String adminpassword, List<Approval> approvals) {
		super();
		this.adminpassword = adminpassword;
		this.approvals = approvals;
	}

	public Admin() {
	}

	public int getAdminid() {
		return this.adminid;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	
	//Json Ignore helps in not printing all the values from the foreign key
	@JsonIgnore
	public List<Approval> getApprovals() {
		return approvals;
	}

	public void setApprovals(List<Approval> approvals) {
		this.approvals = approvals;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

}
