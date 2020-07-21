package com.bank.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.entity.BankAccount;
import com.bank.entity.EBankUsers;
import com.bank.utils.JpaUtils;

@Repository("userdao")
public class EBankUsersDaoImpl implements EBankUsersDao {

	private EntityManager manager;

	public EBankUsersDaoImpl() {
		manager = JpaUtils.getEntityManager();

	}

	@Override
	public String authenticateUser(EBankUsers user1) {

		EBankUsers userFound = manager.find(EBankUsers.class, user1.getUser_Id());
		String msg="";
		if (userFound == null) {
			msg = "Login Failed!";
		} else {
			if (userFound.getPassword().matches(user1.getPassword())) {
				msg = userFound.getCust_Id()+"";
			} else {
				msg = "Login Failed!";
			}
		}
		System.out.println("login "+msg);
		return msg;
	}

	@Override

	public boolean registerUser(EBankUsers user1) {
		boolean flag = false;
		int u_Id;
		String banku_Id=user1.getUser_Id();
		int bankCustId=user1.getCust_Id();
		// Check if user id already present
		EBankUsers user = manager.find(EBankUsers.class, user1.getUser_Id());

		if (user == null) {
			
			//check if password is available
			Query query = manager
					.createQuery("select e.user_Id FROM EBankUsers e WHERE e.password ='" + user1.getPassword() + "'");
			u_Id = query.getFirstResult();

			if (u_Id == 0) {

				manager.getTransaction().begin();
				manager.persist(user1);
				manager.getTransaction().commit();
			query = manager
						.createQuery("select e.user_Id FROM EBankUsers e WHERE e.password ='" + user1.getPassword() + "'");
			u_Id = query.getFirstResult();
				BankAccount b=new BankAccount();
				query = manager
						.createQuery("select b.account_No from BankAccount b where b.customer_Id="+user1.getCust_Id());
				manager.getTransaction().begin();
				Long acNo=(long)Integer.parseInt(query.getSingleResult().toString());
				b=manager.find(BankAccount.class,acNo);
				b.setUser_Id(banku_Id);
				manager.getTransaction().commit();
				
				flag = true;
			}
		} else {
			flag = false;
		}
		return flag;
	}

}
