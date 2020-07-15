package com.bank.dao;



import java.rmi.server.UID;
import java.sql.Date;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.bank.entity.BankAccount;
import com.bank.entity.EBankUsers;
import com.bank.entity.UserTransactions;
import com.bank.utils.JpaUtils;


@Repository("userTransactionsdao")
public class UserTransactionsDaoImpl implements UserTransactionsDao {



private EntityManager manager;
	

public UserTransactionsDaoImpl() {
	manager = JpaUtils.getEntityManager();
		 
}


@Override
public String initiateNewTransaction(UserTransactions t1) {
	
	System.out.println(t1);
	manager.getTransaction().begin();
	manager.persist(t1);
	manager.getTransaction().commit();
	return "Transaction is in progress...";
}


@Override
public String updateTransaction(UserTransactions t1) {
	String msg="";
	UserTransactions t2=manager.find(UserTransactions.class,t1.getTransaction_Id());
	String status=t1.getStatus();
	if(status.equals("Fail"))
	msg="Transaction Cancelled.";
	if(status.equals("Success"))
	{
		int amt=t2.getAmount();
		int bal=t2.getBalance();
		System.out.println(bal);
		int newBalance = bal-amt;
		t2.getBankAC().setBalance(newBalance);
		
		msg="Reference_Id : "+t1.getReference_Id()+"\nTransaction Successful!";
	}
	
	t2.setStatus(t1.getStatus());
	manager.getTransaction().begin();
	manager.persist(t2);
	manager.getTransaction().commit();
	return msg;
	
}


@Override
public List<UserTransactions> getMiniStatement(long fromAC_No) {

	String hql="From UserTransactions t where t.bankAC.account_No="+fromAC_No+" order by t.timestamp desc";
	
	List<UserTransactions> statements=(List<UserTransactions>) manager.createQuery(hql).setFirstResult(0).setMaxResults(10).getResultList();
	
	
	return statements;
}


@Override
public boolean checkBalance(UserTransactions t1) {
	boolean flag;
	
	int balance=t1.getBalance();
	int amount=t1.getAmount();
	if((balance-amount)<0)
		flag=false;
	else 
		flag=true;
	
	return flag;
	
}


@Override
public String generateRefID() {
	
	 UID u_Id = new UID();
	 String ref_Id=u_Id.toString(); 
	 
	return ref_Id;
}


@Override
public String getUserT_Pin(String user1) {
	System.out.println(user1);
	EBankUsers user=manager.find(EBankUsers.class,user1);
	System.out.println(user);
	return user.getT_Pin();
}


@Override
public UserTransactions linkFrom_AC(UserTransactions t1, long from_AC) {
	
	BankAccount b=manager.find(BankAccount.class,from_AC);
	//System.out.println(b);
	if(b==null) {
		
	}
	else
	t1.setBankAC(b);
	return t1;
}




	
}
