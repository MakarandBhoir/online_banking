package com.bank.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usertransactions")
public class UserTransactions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TransId_seq")
	@SequenceGenerator(name="TransId_seq",sequenceName="TransId_seq",allocationSize=1)
	@Column(name="Transaction_Id")
	private long transaction_Id;
	
	//@Column(name="From_AC") 
	//private long from_AC;
	 
	
	@Column(name="To_AC")
	private long to_AC;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "From_AC",referencedColumnName = "Account_No",nullable = false,insertable = false,updatable = false)
	private BankAccount bankAC;
	
	public Long getFrom_AC(){
        return this.getBankAC().getAccount_No();
    }

    
    public int getBalance(){
        return this.getBankAC().getBalance();
    }

    
    @JsonIgnore
	public void setBankAC(BankAccount bankAC) {
		this.bankAC = bankAC;
	}

    @JsonIgnore
	public BankAccount getBankAC() {
		return bankAC;
	}

	


	/*
	 * @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "User_Id") private EBankUsers eBankUser; public EBankUsers
	 * geteBankUser() { return eBankUser; }
	 * 
	 * public void seteBankUser(EBankUsers eBankUser) { this.eBankUser = eBankUser;
	 * }
	 */

	




	public UserTransactions() {}

	public UserTransactions(long transaction_Id,BankAccount from_AC, long to_AC, Date timestamp, int amount, String mode,
			String remark, String status, String user_Id,String reference_Id) {
		super();
		this.transaction_Id = transaction_Id;
		this.bankAC=from_AC;
		this.to_AC = to_AC;
		this.timestamp = timestamp;
		this.amount = amount;
		this.mode = mode;
		this.remark = remark;
		this.status = status;
		this.user_Id = user_Id;
		this.reference_Id = reference_Id;
	}



	public long getTransaction_Id() {
		return transaction_Id;
	}



	public void setTransaction_Id(long transaction_Id) {
		this.transaction_Id = transaction_Id;
	}



	
	//  public long getFrom_AC() { return from_AC; }
	  
	  
	  
	//  public void setFrom_AC(long from_AC) { this.from_AC = from_AC; }
	 



	public long getTo_AC() {
		return to_AC;
	}



	public void setTo_AC(long to_AC) {
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


	public String getReference_Id() {
		return reference_Id;
	}



	public void setReference_Id(String reference_Id) {
		this.reference_Id = reference_Id;
	}



	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	//public void setFrom_AC(long from_AC) {
		//this.from_AC = from_AC;
	//}


	@Override
	public String toString() {
		return "Transactions [transaction_Id=" + transaction_Id + ", from_AC=" +bankAC.getAccount_No() + ", to_AC=" + to_AC
				+ ", timestamp=" + timestamp + ", amount=" + amount + ", mode=" + mode + ", remark=" + remark
				+ ", status=" + status + ", user_Id=" + user_Id + ", reference_Id=" + reference_Id + "]";
	}
	
	
	
	

	
}
