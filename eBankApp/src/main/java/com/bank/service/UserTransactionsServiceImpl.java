package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bank.dao.UserTransactionsDao;
import com.bank.entity.UserTransactions;

@Service
public class UserTransactionsServiceImpl implements UserTransactionsService{

	@Autowired
	@Qualifier("userTransactionsdao")
	UserTransactionsDao userTransactionsdao;
	
	public UserTransactionsServiceImpl() {}
	
	

	@Override
	public String initiateNewTransaction(UserTransactions t1) {
		
		return userTransactionsdao.initiateNewTransaction(t1);
	}

	

	@Override
	public String updateTransaction(UserTransactions t1) {
		String msg=userTransactionsdao.updateTransaction(t1);
		return msg;
	}

	@Override
	public List<UserTransactions> getMiniStatement(long fromAC_No) {
		return userTransactionsdao.getMiniStatement(fromAC_No);
	}



	@Override
	public Boolean isSufficientBalance(UserTransactions t1) {
		Boolean flag=userTransactionsdao.checkBalance(t1);
		return flag;
		
	}



	@Override
	public String completeTransaction(UserTransactions t1) {
		String ref_Id=userTransactionsdao.generateRefID();
		System.out.println(ref_Id);
		t1.setReference_Id(ref_Id);
		String msg=userTransactionsdao.updateTransaction(t1);
		return msg;
	
	}



	@Override
	public String getUserT_Pin(String user1) {
		
		return userTransactionsdao.getUserT_Pin(user1);
	}



	@Override
	public UserTransactions linkFrom_AC(UserTransactions t1, long from_AC) {
		return userTransactionsdao.linkFrom_AC(t1 ,from_AC);
		
	}

}
