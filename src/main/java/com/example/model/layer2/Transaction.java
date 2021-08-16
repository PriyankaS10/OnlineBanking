package com.example.model.layer2;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

//This is the pojo of Transaction Details which we are taking from the oracle

@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionid;

	private int amounttransferred;

	private String modeoftransaction;

	private String remarks;

	private LocalDate transactiondate = java.time.LocalDate.now();

	//bi-directional many-to-one association to Accountdetail
	@ManyToOne
	@JoinColumn(name="TOACCOUNT", referencedColumnName="ACCOUNTNUMBER")
	private Accountdetail accountto;
	
	@ManyToOne
	@JoinColumn(name="FROMACCOUNT", referencedColumnName="ACCOUNTNUMBER")
	private Accountdetail accountfrom;
	
	
	public Transaction(long transactionid, int amounttransferred, String modeoftransaction, String remarks,
			LocalDate transactiondate, Accountdetail accountto, Accountdetail accountfrom) {
		super();
		this.transactionid = transactionid;
		this.amounttransferred = amounttransferred;
		this.modeoftransaction = modeoftransaction;
		this.remarks = remarks;
		this.transactiondate = transactiondate;
		this.accountto = accountto;
		this.accountfrom = accountfrom;
	}
	
	public Transaction() {
	}
	
	//Json Ignore helps in not printing all the values from the foreign key
	@JsonIgnore
	public Accountdetail getAccountto() {
		return accountto;
	}
	
	public void setAccountto(Accountdetail accountto) {
		this.accountto = accountto;
	}
	
	@JsonIgnore
	public Accountdetail getAccountfrom() {
		return accountfrom;
	}

	public void setAccountfrom(Accountdetail accountfrom) {
		this.accountfrom = accountfrom;
	}

	public long getTransactionid() {
		return this.transactionid;
	}

	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}

	public int getAmounttransferred() {
		return this.amounttransferred;
	}

	public void setAmounttransferred(int amounttransferred) {
		this.amounttransferred = amounttransferred;
	}

	public String getModeoftransaction() {
		return this.modeoftransaction;
	}

	public void setModeoftransaction(String modeoftransaction) {
		this.modeoftransaction = modeoftransaction;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDate getTransactiondate() {
		return this.transactiondate;
	}

	public void setTransactiondate(LocalDate transactiondate) {
		this.transactiondate = transactiondate;
	}
	
	public int getToAccountNumber() {
		return this.accountto.getAccountnumber();
	}
	
	public int getFromAccountNumber() {
		return this.accountfrom.getAccountnumber();
	}
}