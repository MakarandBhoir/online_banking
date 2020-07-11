package com.bank.service;

import com.bank.entity.EBankUsers;

public interface EBankUsersService {
	public String authenticateUser(EBankUsers user1);
	
	public String registerUser(EBankUsers user1 );
}
