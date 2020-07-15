package com.bank.dao;

import java.util.List;

import com.bank.entity.BankAccount;
import com.bank.service.BankAccountService;

public interface BankAccountDao {
	public List<BankAccount> viewBankAccount(Long custid);

	public BankAccount viewBankAccountById(Long custid, Long acctid);
}
