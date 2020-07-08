package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "beneficiary")
public class Beneficiary {

	@Id
	@Column(name="User_Id")
	private String userId;
	
	@Column(name="PayeeAC_No")
	private int payeeACno;
	
	@Column(name="Bank_Name")
	private String bankName;
	
	@Column(name="IFSC")
	private String ifsc;
	
	@Column(name="Nick_Name")
	private String nickName;
	
	

	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public int getPayeeACno() {
		return payeeACno;
	}



	public void setPayeeACno(int payeeACno) {
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
		return "Beneficiary [user_id=" + userId + ", payeeACno=" + payeeACno + ", bankName=" + bankName + ", ifsc="
				+ ifsc + ", nickName=" + nickName + "]";
	}
	
	
}
