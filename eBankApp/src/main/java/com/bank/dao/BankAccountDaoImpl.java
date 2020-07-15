package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bank.entity.AccountRequest;
import com.bank.entity.BankAccount;
import com.bank.service.BankAccountService;
import com.bank.utils.JpaUtils;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
	private EntityManager manager;
	

	public BankAccountDaoImpl() {
		manager = JpaUtils.getEntityManager();
	}

	
	
	@Override
	public List<BankAccount> viewBankAccount(Long custid) {
		List<BankAccount> bnkacct=new ArrayList<BankAccount>();
		String query="from BankAccount b where b.customer_Id ="+custid;
		bnkacct= (ArrayList<BankAccount>) manager.createQuery(query).getResultList();
		return bnkacct;
		
	}



	@Override
	public BankAccount viewBankAccountById(Long custid,Long acctid) {
		BankAccount bnkacct=new BankAccount();
		String query="from BankAccount b where b.customer_Id="+custid+" AND b.account_No="+acctid;
		bnkacct= (BankAccount) manager.createQuery(query).getSingleResult();
		return bnkacct;
	}

}
