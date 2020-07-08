package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "admin" )
public class Admin {

	@Id
	@Column(name ="Admin_Id")
	private String admin_Id;
	@Column(name="Password")
	private String password;
	
	
	public String getAdmin_Id() {
		return admin_Id;
	}

/*
	public void setAdmin_Id(String admin_Id) {
		this.admin_Id = admin_Id;
	}
*/

	public String getPassword() {
		return password;
	}


/*	public void setPassword(String password) {
		this.password = password;
	}

*/
	@Override
	public String toString() {
		return "Admin [admin_Id=" + admin_Id + ", password=" + password + "]";
	}
	
	
	
}
