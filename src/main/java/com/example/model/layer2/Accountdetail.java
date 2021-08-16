package com.example.model.layer2;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//This is the pojo of Account Details which we are taking from the oracle

@Entity
@Table(name = "ACCOUNTDETAILS")
@NamedQuery(name = "Accountdetail.findAll", query = "SELECT a FROM Accountdetail a")
public class Accountdetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;

	private String accountlock="N";

	private String accountstatus="N";

	private String accounttype;

	private LocalDate createdon = java.time.LocalDate.now();

	private int currentbalance;

	private String loginpassword;

	private String transactionpassword;
	
	private String userid;
	
	//Generating Random Values for AccountNumber
	private int accountnumber = (int)(Math.random()*10000);

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	// bi-directional one-to-one association to Customerdetail
	@OneToOne
	@JoinColumn(name = "CUSTID",referencedColumnName="CUSTID")
	Customerdetail customerdetail;

	// bi-directional many-to-one association to Payee
	@OneToMany(mappedBy = "accountdetail", cascade = CascadeType.ALL)
	private List<Payee> payees;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "accountto", cascade = CascadeType.ALL)
	private List<Transaction> transactionto;

	@OneToMany(mappedBy = "accountfrom", cascade = CascadeType.ALL)
	private List<Transaction> transactionfrom;
	
	public Accountdetail(String accounttype, int currentbalance, String loginpassword, String transactionpassword, Customerdetail customerdetail) 
	{
		super();
		this.accounttype = accounttype;
		this.currentbalance = currentbalance;
		this.loginpassword = loginpassword;
		this.transactionpassword = transactionpassword;
		this.customerdetail = customerdetail;
	}


	//Json Ignore helps in not printing all the values from the foreign key
	@JsonIgnore
	public List<Payee> getPayees() {
		return payees;
	}

	@JsonIgnore
	public List<Transaction> getTransactionto() {
		return transactionto;
	}

	public void setTransactionto(List<Transaction> transactionto) {
		this.transactionto = transactionto;
	}
	@JsonIgnore
	public List<Transaction> getTransactionfrom() {
		return transactionfrom;
	}

	public void setTransactionfrom(List<Transaction> transactionfrom) {
		this.transactionfrom = transactionfrom;
	}

	public void setPayees(List<Payee> payees) {
		this.payees = payees;
	}
	
	@JsonIgnore
	public Customerdetail getCustomerdetail() {
		return customerdetail;
	}

	public void setCustomerdetail(Customerdetail customerdetail) {
		this.customerdetail = customerdetail;
	}

	public Accountdetail() {
	}


	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getAccountlock() {
		return this.accountlock;
	}

	public void setAccountlock(String accountlock) {
		this.accountlock = accountlock;
	}

	public String getAccountstatus() {
		return this.accountstatus;
	}

	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}

	public String getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public LocalDate getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(LocalDate createdon) {
		this.createdon = createdon;
	}

	public int getCurrentbalance() {
		return this.currentbalance;
	}

	public void setCurrentbalance(int currentbalance) {
		this.currentbalance = currentbalance;
	}

	public String getLoginpassword() {
		return this.loginpassword;
	}

	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}

	public String getTransactionpassword() {
		return this.transactionpassword;
	}

	public void setTransactionpassword(String transactionpassword) {
		this.transactionpassword = transactionpassword;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getCustId() {
		return this.customerdetail.getCustid();
	}
	
}