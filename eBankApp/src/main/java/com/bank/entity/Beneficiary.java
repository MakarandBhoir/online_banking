package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "beneficiary")
public class Beneficiary {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bene_seq")
	@SequenceGenerator(name="bene_seq",sequenceName="bene_seq",initialValue = 1,allocationSize=1)
	@Column(name="B_Id") 
	private int b_Id;
	
	@Column(name="User_Id") 
	private String user_Id;
	
	
	@Column(name="PayeeAC_No")
	private long payeeACno;
	
	@Column(name="Bank_Name")
	private String bankName;
	
	@Column(name="IFSC")
	private String ifsc;
	
	@Column(name="Nick_Name")
	private String nickName;
	
	/*@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	private EBankUsers eBankUser;
	
	public EBankUsers geteBankUser() {
		return eBankUser;
	}

	public void seteBankUser(EBankUsers eBankUser) {
		this.eBankUser = eBankUser;
	}*/

	public Beneficiary() {}

	public Beneficiary(int b_Id,String userId, long payeeACno, String bankName, String ifsc, String nickName,String user) {
		super();
		this.b_Id = b_Id;
		this.payeeACno = payeeACno;
		this.bankName = bankName;
		this.ifsc = ifsc;
		this.nickName = nickName;
		this.user_Id=user;
	}



	public int getB_Id() {
		return b_Id;
	}

	public void setB_Id(int b_Id) {
		this.b_Id = b_Id;
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



	
	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	@Override
	public String toString() {
		return "Beneficiary [b_Id="+b_Id+"user_id=" +user_Id+", payeeACno=" + payeeACno + ", bankName=" + bankName + ", ifsc="
				+ ifsc + ", nickName=" + nickName + "]";
	}
	
	
}
