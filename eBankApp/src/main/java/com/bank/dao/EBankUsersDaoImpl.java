package com.bank.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.bank.entity.EBankUsers;
import com.bank.utils.JpaUtils;

@Repository("userdao")
public class EBankUsersDaoImpl implements EBankUsersDao {
	
	private EntityManager manager;

	
	public EBankUsersDaoImpl() {
		manager = JpaUtils.getEntityManager();
		System.out.println(" ....manager created");
	}

	@Override
	public boolean authenticateUser(EBankUsers user1) {
		System.out.println(" INSIDE DAO" + user1.getUser_Id());
		EBankUsers userFound = manager.find(EBankUsers.class, user1.getUser_Id());
		boolean flag;
		if (userFound == null) {
			flag = false;
		} else {
			if (userFound.getPassword().matches(user1.getPassword())) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	@Override
	
	public boolean registerUser(EBankUsers user1) {
		boolean flag=false;
		int u_Id;
		System.out.println("in dao  ...."+user1.toString());
		EBankUsers user=manager.find(EBankUsers.class, user1.getUser_Id());
		System.out.println("in dao"+user);
		if (user == null) {
			Query query = manager.createQuery("select e.user_Id FROM EBankUsers e WHERE e.password ='"+user1.getPassword()+"'" );
			u_Id= query.getFirstResult();
			System.out.println("u_Id ...."+u_Id);
		    if(u_Id==0)
		    {
			System.out.println("...in dao");
				manager.getTransaction().begin();
			manager.persist(user1);
			manager.getTransaction().commit();
		
			flag = true;
		    }
		} else {
			flag = false;
		}
		return flag;
	}

}
