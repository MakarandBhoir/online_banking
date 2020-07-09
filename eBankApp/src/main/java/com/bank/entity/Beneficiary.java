package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "beneficiary")
public class Beneficiary {

	
	
	//@Column(name="User_Id") 
	//private String userId;
	
	
	@Column(name="PayeeAC_No")
	private long payeeACno;
	
	@Column(name="Bank_Name")
	private String bankName;
	
	@Column(name="IFSC")
	private String ifsc;
	
	@Column(name="Nick_Name")
	private String nickName;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	private EBankUsers eBankUser;
	public EBankUsers getEBankUsers() {
		return eBankUser;
	}

	public void setEBankUsers(EBankUsers eBankUser1) {
		this.eBankUser = eBankUser1;
	}

	
	public Beneficiary() {}

	public Beneficiary(String userId, long payeeACno, String bankName, String ifsc, String nickName) {
		super();
		//this.userId = userId;
		this.payeeACno = payeeACno;
		this.bankName = bankName;
		this.ifsc = ifsc;
		this.nickName = nickName;
	}



	public long getPayeeACno() {
		return payeeACno;
	}



	public void setPayeeACno(long payeeACno) {
		this.payeeACno = payeeACno;
	}



	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	public String getIfsc() {
		return ifsc;
	}



	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}



	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	@Override
	public String toString() {
		return "Beneficiary [user_id=" + eBankUser.getUser_Id() + ", payeeACno=" + payeeACno + ", bankName=" + bankName + ", ifsc="
				+ ifsc + ", nickName=" + nickName + "]";
	}
	
	
}
