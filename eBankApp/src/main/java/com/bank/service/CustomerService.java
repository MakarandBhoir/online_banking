package com.bank.service;

import java.util.List;

import com.bank.entity.Customer;

public interface CustomerService {
	
	public Customer viewProfile(Long custid);
	public void viewAccountSummary();
	public void vewAccountDetails();

}
