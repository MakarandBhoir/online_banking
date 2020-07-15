package com.bank.service;

import java.util.List;

import com.bank.entity.BankAccount;

public interface BankAccountService {
	
	public List<BankAccount> viewBankAccount(Long custid);

	public BankAccount viewBankAccountById(Long custid, Long acctid);

}
