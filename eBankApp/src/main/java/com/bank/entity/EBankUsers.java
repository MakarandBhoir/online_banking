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
