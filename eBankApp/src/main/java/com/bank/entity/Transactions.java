package com.bank.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transactions {
	
	@Id
	@Column(name="Transaction_Id")
	private int transaction_Id;
	
	@Column(name="From_AC")
	private int from_AC;
	
	@Column(name="To_AC")
	private int to_AC;
	
	@Column(name= "Timestamp")
	private Date timestamp;
	
	@Column(name="Amount")
	private int amount;
	
	@Column(name="Mode")
	private String mode;
	
	@Column(name="Remark")
	private String remark;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="User_Id")
	private String user_Id;
	
	@Column(name="Reference_Id")
	private String reference_Id;
	
	

	public int getTransaction_Id() {
		return transaction_Id;
	}



	public void setTransaction_Id(int transaction_Id) {
		this.transaction_Id = transaction_Id;
	}



	public int getFrom_AC() {
		return from_AC;
	}



	public void setFrom_AC(int from_AC) {
		this.from_AC = from_AC;
	}



	public int getTo_AC() {
		return to_AC;
	}



	public void setTo_AC(int to_AC) {
		this.to_AC = to_AC;
	}



	public Date getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public String getMode() {
		return mode;
	}



	public void setMode(String mode) {
		this.mode = mode;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getUser_Id() {
		return user_Id;
	}



	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}



	public String getReference_Id() {
		return reference_Id;
	}



	public void setReference_Id(String reference_Id) {
		this.reference_Id = reference_Id;
	}



	@Override
	public String toString() {
		return "Transactions [transaction_Id=" + transaction_Id + ", from_AC=" + from_AC + ", to_AC=" + to_AC
				+ ", timestamp=" + timestamp + ", amount=" + amount + ", mode=" + mode + ", remark=" + remark
				+ ", status=" + status + ", user_Id=" + user_Id + ", reference_Id=" + reference_Id + "]";
	}
	
	
	
	

	
}
