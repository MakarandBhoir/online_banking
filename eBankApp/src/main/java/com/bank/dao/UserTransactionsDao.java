package com.bank.dao;


import java.util.List;

import com.bank.entity.UserTransactions;

public interface UserTransactionsDao {
	public String initiateNewTransaction(UserTransactions t1);
	public String updateTransaction(UserTransactions t1);
	public String generateRefID();
	public List<UserTransactions> getMiniStatement(long fromAC_No);
	public boolean checkBalance(UserTransactions t1);
	public String getUserT_Pin(String user1);
	public UserTransactions linkFrom_AC(UserTransactions t1 ,long from_AC);
}
