package com.bank.dao;


import com.bank.entity.Admin;
import com.bank.entity.EBankUsers;

public interface EBankUsersDao {
	public String authenticateUser(EBankUsers user1);
	public boolean registerUser(EBankUsers user1);
	
}
