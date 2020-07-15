package com.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.BankAccountDao;
import com.bank.dao.CustomerDao;
import com.bank.entity.BankAccount;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	@Autowired
	private BankAccountDao bnkAcctdao;
	
	@Override
	public List<BankAccount> viewBankAccount(Long custid) {
		List<BankAccount> bnklist=new ArrayList<BankAccount>();
		bnklist=bnkAcctdao.viewBankAccount(custid);
		return bnklist;
	}

	@Override
	public BankAccount viewBankAccountById(Long custid, Long acctid) {
		BankAccount bnklist=new BankAccount();
		bnklist=bnkAcctdao.viewBankAccountById(custid,acctid);
		return bnklist;
	}

}
