package com.bank.service;


import java.util.List;

import com.bank.entity.UserTransactions;

public interface UserTransactionsService {
	public String initiateNewTransaction(UserTransactions t1);
	public String updateTransaction(UserTransactions t1);
	public String completeTransaction(UserTransactions t1);
	public List<UserTransactions> getMiniStatement(long from_AC);
	public Boolean isSufficientBalance(UserTransactions t1);
	public String getUserT_Pin(String user1);
	public UserTransactions linkFrom_AC(UserTransactions t1 ,long from_AC);
}
