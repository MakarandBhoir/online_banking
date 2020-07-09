package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "ebankusers")
public class EBankUsers {
	
	@Id
	@Column(name="User_Id")
	private String user_Id;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Transaction_Pin")
	private int transaction_pin;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	private BankAccount bankAccount;  
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	
	public void setBankAccount(BankAccount bankAccount1) {
		this.bankAccount = bankAccount1;
	}
	
	
	public EBankUsers() {}
	public EBankUsers(String user_Id, String password, int transaction_pin) {
		super();
		this.user_Id = user_Id;
		this.password = password;
		this.transaction_pin = transaction_pin;
	}



	public String getUser_Id() {
		return user_Id;
	}



	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getTransaction_pin() {
		return transaction_pin;
	}



	public void setTransaction_pin(int transaction_pin) {
		this.transaction_pin = transaction_pin;
	}



	@Override
	public String toString() {
		return "EBankUsers [user_Id=" + user_Id + ", password=" + password + ", transaction_pin=" + transaction_pin
				+ "]";
	}
	
	

}
