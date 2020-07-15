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

	}

	@Override
	public boolean authenticateUser(EBankUsers user1) {

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
		boolean flag = false;
		int u_Id;

		EBankUsers user = manager.find(EBankUsers.class, user1.getUser_Id());

		if (user == null) {
			Query query = manager
					.createQuery("select e.user_Id FROM EBankUsers e WHERE e.password ='" + user1.getPassword() + "'");
			u_Id = query.getFirstResult();

			if (u_Id == 0) {

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
