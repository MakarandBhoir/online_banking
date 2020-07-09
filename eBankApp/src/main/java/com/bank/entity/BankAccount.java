package com.bank.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Account_seq")
	@SequenceGenerator(name="Account_seq",sequenceName="Account_seq",allocationSize=1)
	@Column(name="Account_No")
	private long account_No;
	
	
	//@Column(name="Customer_Id")
	//private long customer_Id;
	
	@Column(name="Type")
	private String type;
	
	@Column(name="AC_Creation_Date")
	private Date AC_Date;
	
	@Column(name="Balance")
	private int balance;
	
	@Column(name="Registered_Mobile")
	private String Mobile;
	
	@Column(name="Registered_Email")
	private String email;
	
	@Column(name="IFSC")
	private String ifsc;
	
	@Column(name="Branch")
	private String branch;
	
	@Column(name="User_Id")
	private String user_Id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_Id")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer1) {
		this.customer = customer1;
	}


	public BankAccount() {}
	public BankAccount(long account_No, long customer_Id, String type, Date aC_Date, int balance, String mobile,
			String email, String ifsc, String branch, String user_Id) {
		super();
		this.account_No = account_No;
		//this.customer_Id = customer_Id;
		this.type = type;
		AC_Date = aC_Date;
		this.balance = balance;
		Mobile = mobile;
		this.email = email;
		this.ifsc = ifsc;
		this.branch = branch;
		this.user_Id = user_Id;
	}



	public long getAccount_No() {
		return account_No;
	}



	public void setAccount_No(long account_No) {
		this.account_No = account_No;
	}



	

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Date getAC_Date() {
		return AC_Date;
	}



	public void setAC_Date(Date aC_Date) {
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
		return "BankAccount [account_No=" + account_No + ", customer_Id=" + customer.getCustomer_Id() + ", type=" + type
				+ ", AC_Date=" + AC_Date + ", balance=" + balance + ", Mobile=" + Mobile + ", email=" + email
				+ ", ifsc=" + ifsc + ", branch=" + branch + ", user_Id=" + user_Id + "]";
	}
	
	
}
