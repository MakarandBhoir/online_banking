package com.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.AccountRequest;
import com.bank.entity.BankAccount;
import com.bank.service.AccountRequestService;
import com.bank.service.BankAccountService;

@RestController
@RequestMapping(path = "bankAcct")
public class BankAccountController {

	@Autowired
	private BankAccountService bnkacctsrv;
	
	@GetMapping(path = "viewAcct/{custid}")
	@CrossOrigin(origins="http://localhost:4200")
	public List<BankAccount> viewBankAccount(@PathVariable("custid") Long custid) {
		List<BankAccount> bnkacct=new ArrayList<BankAccount>();
		bnkacct=bnkacctsrv.viewBankAccount(custid);
		return bnkacct;
		
	}
	
	@GetMapping(path = "viewAcctbyid/{custid}/{acctid}")
	public BankAccount viewBankAccountById(@PathVariable("custid") Long custid,@PathVariable("acctid") Long acctid) {
		BankAccount bnkacct=new BankAccount();
		bnkacct=bnkacctsrv.viewBankAccountById(custid,acctid);
		return bnkacct;
		
	}
	
	
}
