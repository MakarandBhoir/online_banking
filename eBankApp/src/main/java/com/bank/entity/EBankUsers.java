package com.bank.entity;

import javax.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "ebankusers")
public class EBankUsers {
	
	@Id
	@Column(name="User_Id")
	private String user_Id;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Transaction_Pin")
	private String transaction_pin;
	
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name = "User_Id",referencedColumnName = "User_Id")
	//@JsonManagedReference
	//private Set<BankAccount> bankAccounts;
	//public Set<BankAccount> getBankAccounts() {
	//	  return bankAccounts;
	//	 }

	//	 public void setBankAccounts(Set<BankAccount> bankAccounts) {
	//	  this.bankAccounts = bankAccounts;
	//	 }
	
/*	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinColumn(name = "User_Id",referencedColumnName = "User_Id")
		@JsonManagedReference
		private Set<Beneficiary> beneficiary;
		
	
	
	public Set<Beneficiary> getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Set<Beneficiary> beneficiary) {
		this.beneficiary = beneficiary;
	}*/
	public EBankUsers() {}
	public EBankUsers(String user_Id, String password, String transaction_pin) {
		super();
		this.user_Id = user_Id;
		this.password = password;
		this.transaction_pin = transaction_pin;
	}
	public EBankUsers(String user_Id, String password) {
		super();
		this.user_Id = user_Id;
		this.password = password;
		//this.transaction_pin = transaction_pin;
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



	public String getTransaction_pin() {
		return transaction_pin;
	}



	public void setTransaction_pin(String transaction_pin) {
		this.transaction_pin = transaction_pin;
	}



	@Override
	public String toString() {
		return "EBankUsers [user_Id=" + user_Id + ", password=" + password + ", transaction_pin=" + transaction_pin
				+ "]";
	}
	
	

}
