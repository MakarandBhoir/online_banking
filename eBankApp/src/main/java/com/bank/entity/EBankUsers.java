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
	private String t_Pin;
	
	@Column(name="cust_Id")
	private int cust_Id;
	
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
	public EBankUsers(String user_Id, String password, String t_Pin) {
		super();
		this.user_Id = user_Id;
		this.password = password;
		this.t_Pin = t_Pin;
	}
	


	public int getCust_Id() {
		return cust_Id;
	}
	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
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



	public String getT_Pin() {
		return t_Pin;
	}



	public void setT_Pin(String t_Pin) {
		this.t_Pin = t_Pin;
	}



	@Override
	public String toString() {
		return "EBankUsers [user_Id=" + user_Id + ", password=" + password + ", transaction_Pin=" + t_Pin
				+ "]";
	}
	
	

}
