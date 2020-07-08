package com.bank.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name ="customer_details")
public class Customer {

	@Id
	@Column(name="Customer_Id")
	private int customer_Id;
	
	@Column(name="First_Name")
	private String first_Name;
	
	@Column(name="Middle_Name")
	private String middle_Name;
	
	@Column(name="Last_Name")
	private String last_Name;
	
	@Column(name="Father_Name")
	private String father_Name;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Occupation_Type")
	private String occupation_Type;
	
	@Column(name="Income_Source")
	private String income_Source;
	
	@Column(name="Gross_Income")
	private int gross_Income;
	
	@Column(name="Adhar_Card")
	private String adhar_No;
	
	@Column(name="Pan_Card")
	private String pan_No;
	
	@Column(name="Permanant_Address")
	private String permanant_Address;
	
	@Column(name="Residential_Address")
	private String residential_Address;
	
	@Column(name="Apply_date")
	private Date apply_Date;

	
	
	public int getCustomer_Id() {
		return customer_Id;
	}



	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}



	public String getFirst_Name() {
		return first_Name;
	}



	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}



	public String getMiddle_Name() {
		return middle_Name;
	}



	public void setMiddle_Name(String middle_Name) {
		this.middle_Name = middle_Name;
	}



	public String getLast_Name() {
		return last_Name;
	}



	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}



	public String getFather_Name() {
		return father_Name;
	}



	public void setFather_Name(String father_Name) {
		this.father_Name = father_Name;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getOccupation_Type() {
		return occupation_Type;
	}



	public void setOccupation_Type(String occupation_Type) {
		this.occupation_Type = occupation_Type;
	}



	public String getIncome_Source() {
		return income_Source;
	}



	public void setIncome_Source(String income_Source) {
		this.income_Source = income_Source;
	}



	public int getGross_Income() {
		return gross_Income;
	}



	public void setGross_Income(int gross_Income) {
		this.gross_Income = gross_Income;
	}



	public String getAdhar_No() {
		return adhar_No;
	}



	public void setAdhar_No(String adhar_No) {
		this.adhar_No = adhar_No;
	}



	public String getPan_No() {
		return pan_No;
	}



	public void setPan_No(String pan_No) {
		this.pan_No = pan_No;
	}



	public String getPermanant_Address() {
		return permanant_Address;
	}



	public void setPermanant_Address(String permanant_Address) {
		this.permanant_Address = permanant_Address;
	}



	public String getResidential_Address() {
		return residential_Address;
	}



	public void setResidential_Address(String residential_Address) {
		this.residential_Address = residential_Address;
	}



	public Date getApply_Date() {
		return apply_Date;
	}



	public void setApply_Date(Date apply_Date) {
		this.apply_Date = apply_Date;
	}



	@Override
	public String toString() {
		return "Customer [customer_Id=" + customer_Id + ", first_Name=" + first_Name + ", middle_Name=" + middle_Name
				+ ", last_Name=" + last_Name + ", father_Name=" + father_Name + ", dob=" + dob + ", email=" + email
				+ ", phone=" + phone + ", occupation_Type=" + occupation_Type + ", income_Source=" + income_Source
				+ ", gross_Income=" + gross_Income + ", adhar_No=" + adhar_No + ", pan_No=" + pan_No
				+ ", permanant_Address=" + permanant_Address + ", residential_Address=" + residential_Address
				+ ", apply_Date=" + apply_Date + "]";
	}
	
	
}
