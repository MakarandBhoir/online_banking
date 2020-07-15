package com.bank.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountRequestDao;
import com.bank.dao.CustomerDao;
import com.bank.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao custdao;
	
	@Override
	public Customer viewProfile(Long custid)
	{
		Customer custpr=custdao.viewProfile(custid);
		return custpr;
	}

	@Override
	public void viewAccountSummary() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vewAccountDetails() {
		// TODO Auto-generated method stub
		
	}

}
