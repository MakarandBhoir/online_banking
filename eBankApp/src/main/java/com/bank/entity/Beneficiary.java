package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "beneficiary")
public class Beneficiary {

	@Id
	@Column(name="User_Id")
	String user_id;
	
	@Column(name="PayeeAC_No")
	int payeeACno;
	
	@Column(name="Bank_Name")
	String bankName;
	
	@Column(name="IFSC")
	String ifsc;
	
	@Column(name="Nick_Name")
	String nickName;
	
	

	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
		return "Beneficiary [user_id=" + user_id + ", payeeACno=" + payeeACno + ", bankName=" + bankName + ", ifsc="
				+ ifsc + ", nickName=" + nickName + "]";
	}
	
	
}
