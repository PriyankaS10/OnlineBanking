package com.example.model.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

//This is the pojo of Customer Details which we are taking from the oracle

@Entity
@Table(name="CUSTOMERDETAILS")
@NamedQuery(name="Customerdetail.findAll", query="SELECT c FROM Customerdetail c")
public class Customerdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custid;

	private String debitcard;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	private String fathername;

	private String firstname;

	private String grossannualincome;

	private String incomesource;

	private double initialamount;

	private String lastname;

	private String middlename;

	private String mobilenumber;

	private String occupationtype;

	private String optnetbanking;

	private String city;

	private String landmark;

	private String line1;

	private String line2;

	private int pincode;

	private String state;

	private String title;
	
	private int aadharnumber;
	
	//bi-directional one-to-one association to Accountdetail
	@OneToOne(mappedBy="customerdetail",cascade = CascadeType.ALL)
	Accountdetail accountdetail;
		
	@OneToOne(mappedBy="customerdetail",cascade = CascadeType.ALL)
	Approval approval;
	
	public Customerdetail(String debitcard, Date dob, String email, String fathername, String firstname,
			String grossannualincome, String incomesource, double initialamount, String lastname, String middlename,
			String mobilenumber, String occupationtype, String optnetbanking, String city, String landmark,
			String line1, String line2, int pincode, String state, String title, int aadharnumber) {
		super();
		this.debitcard = debitcard;
		this.dob = dob;
		this.email = email;
		this.fathername = fathername;
		this.firstname = firstname;
		this.grossannualincome = grossannualincome;
		this.incomesource = incomesource;
		this.initialamount = initialamount;
		this.lastname = lastname;
		this.middlename = middlename;
		this.mobilenumber = mobilenumber;
		this.occupationtype = occupationtype;
		this.optnetbanking = optnetbanking;
		this.city = city;
		this.landmark = landmark;
		this.line1 = line1;
		this.line2 = line2;
		this.pincode = pincode;
		this.state = state;
		this.title = title;
		this.aadharnumber = aadharnumber;
	}
	
	public int getAadharnumber() {
		return aadharnumber;
	}
	
	public void setAadharnumber(int aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	
	//Json Ignore helps in not printing all the values from the foreign key
	@JsonIgnore
	public Approval getApproval() {
		return approval;
	}

	public void setApproval(Approval approval) {
		this.approval = approval;
	}
	
	@JsonIgnore
	public Accountdetail getAccountdetail() {
		return accountdetail;
	}

	public void setAccountdetail(Accountdetail accountdetail) {
		this.accountdetail = accountdetail;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Customerdetail() {
	}

	public int getCustid() {
		return this.custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getDebitcard() {
		return this.debitcard;
	}

	public void setDebitcard(String debitcard) {
		this.debitcard = debitcard;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFathername() {
		return this.fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGrossannualincome() {
		return this.grossannualincome;
	}

	public void setGrossannualincome(String grossannualincome) {
		this.grossannualincome = grossannualincome;
	}

	public String getIncomesource() {
		return this.incomesource;
	}

	public void setIncomesource(String incomesource) {
		this.incomesource = incomesource;
	}

	public double getInitialamount() {
		return this.initialamount;
	}

	public void setInitialamount(double initialamount) {
		this.initialamount = initialamount;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getMobilenumber() {
		return this.mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getOccupationtype() {
		return this.occupationtype;
	}

	public void setOccupationtype(String occupationtype) {
		this.occupationtype = occupationtype;
	}

	public String getOptnetbanking() {
		return this.optnetbanking;
	}

	public void setOptnetbanking(String optnetbanking) {
		this.optnetbanking = optnetbanking;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

