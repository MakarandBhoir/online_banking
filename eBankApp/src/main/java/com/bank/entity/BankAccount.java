package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {

	@Id
	@Column(name="Account_No")
	int account_No;
	
	
	@Column(name="Customer_Id")
	int customer_Id;
	
	@Column(name="Type")
	String type;
	
	@Column(name="AC_Creation_Date")
	String AC_Date;
	
	@Column(name="Balance")
	int balance;
	
	@Column(name="Registered_Mobile")
	String Mobile;
	
	@Column(name="Registered_Email")
	String email;
	
	@Column(name="IFSC")
	String ifsc;
	
	@Column(name="Branch")
	String branch;
	
	@Column(name="User_Id")
	String user_Id;
	
	

	public int getAccount_No() {
		return account_No;
	}



	public void setAccount_No(int account_No) {
		this.account_No = account_No;
	}



	public int getCustomer_Id() {
		return customer_Id;
	}



	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getAC_Date() {
		return AC_Date;
	}



	public void setAC_Date(String aC_Date) {
		AC_Date = aC_Date;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public String getMobile() {
		return Mobile;
	}



	public void setMobile(String mobile) {
		Mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getIfsc() {
		return ifsc;
	}



	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getUser_Id() {
		return user_Id;
	}



	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}



	@Override
	public String toString() {
		return "BankAccount [account_No=" + account_No + ", customer_Id=" + customer_Id + ", type=" + type
				+ ", AC_Date=" + AC_Date + ", balance=" + balance + ", Mobile=" + Mobile + ", email=" + email
				+ ", ifsc=" + ifsc + ", branch=" + branch + ", user_Id=" + user_Id + "]";
	}
	
	
}
