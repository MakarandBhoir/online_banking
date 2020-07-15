package com.bank.dao;

import java.util.List;

import com.bank.entity.Customer;

public interface CustomerDao {
	public Customer viewProfile(Long custid);
	public void viewAccountSummary();
	public void vewAccountDetails();
}
