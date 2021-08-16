package com.example.model.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

//This is the pojo of Payee Details which we are taking from the oracle

@Entity
@NamedQuery(name="Payee.findAll", query="SELECT p FROM Payee p")
public class Payee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int beneficiaryid;

	private int baccountnumber;

	private String beneficiaryname;

	private String nickname;

	//bi-directional many-to-one association to Accountdetail
	@ManyToOne
	@JoinColumn(name="ACCOUNTNUMBER", referencedColumnName="ACCOUNTNUMBER")
	Accountdetail accountdetail;
	
	public Payee(int baccountnumber, String beneficiaryname, String nickname,
			Accountdetail accountdetail) {
		super();

		this.baccountnumber = baccountnumber;
		this.beneficiaryname = beneficiaryname;
		this.nickname = nickname;
		this.accountdetail = accountdetail;
	}

	public Payee() {
	}

	public long getBeneficiaryid() {
		return this.beneficiaryid;
	}

	public void setBeneficiaryid(int beneficiaryid) {
		this.beneficiaryid = beneficiaryid;
	}

	public int getBaccountnumber() {
		return this.baccountnumber;
	}

	public void setBaccountnumber(int baccountnumber) {
		this.baccountnumber = baccountnumber;
	}

	public String getBeneficiaryname() {
		return this.beneficiaryname;
	}

	public void setBeneficiaryname(String beneficiaryname) {
		this.beneficiaryname = beneficiaryname;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	//Json Ignore helps in not printing all the values from the foreign key
	@JsonIgnore
	public Accountdetail getAccountdetail() {
		return accountdetail;
	}

	public void setAccountdetail(Accountdetail accountdetail) {
		this.accountdetail = accountdetail;
	}
	

}