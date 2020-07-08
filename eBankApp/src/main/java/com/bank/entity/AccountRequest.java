package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "accountrequest")
public class AccountRequest {

	@Id
	@Column(name="Application_Id")
	int application_Id;
	
	@Column(name="First_Name")
	String first_Name;
	
	@Column(name="Middle_Name")
	String middle_Name;
	
	@Column(name="Last_Name")
	String last_Name;
	
	@Column(name="Father_Name")
	String father_Name;
	
	@Column(name="DOB")
	String dob;
	
	@Column(name="Email")
	String email;
	
	@Column(name="Phone")
	String phone;
	
	@Column(name="Occupation_Type")
	String occupation_Type;
	
	@Column(name="Income_Source")
	String income_Source;
	
	@Column(name="Gross_Income")
	int gross_Income;
	
	@Column(name="Adhar_Card")
	String adhar_No;
	
	@Column(name="Pan_Card")
	String pan_No;
	
	@Column(name="Permanant_Address")
	String permanant_Address;
	
	@Column(name="Residential_Address")
	String residential_Address;
	
	@Column(name="Apply_date")
	String apply_Date;
	
	@Column(name="Remark")
	String remark;
	
	@Column(name="Status")
	String status;
	
	

	public int getApplication_Id() {
		return application_Id;
	}



	public void setApplication_Id(int application_Id) {
		this.application_Id = application_Id;
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



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
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



	public String getApply_Date() {
		return apply_Date;
	}



	public void setApply_Date(String apply_Date) {
		this.apply_Date = apply_Date;
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



	@Override
	public String toString() {
		return "AccountRequest [application_Id=" + application_Id + ", first_Name=" + first_Name + ", middle_Name="
				+ middle_Name + ", last_Name=" + last_Name + ", father_Name=" + father_Name + ", dob=" + dob
				+ ", email=" + email + ", phone=" + phone + ", occupation_Type=" + occupation_Type + ", income_Source="
				+ income_Source + ", gross_Income=" + gross_Income + ", adhar_No=" + adhar_No + ", pan_No=" + pan_No
				+ ", permanant_Address=" + permanant_Address + ", residential_Address=" + residential_Address
				+ ", apply_Date=" + apply_Date + ", remark=" + remark + ", status=" + status + "]";
	}
	
	
	
	
}
