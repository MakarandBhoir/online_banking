package com.bank.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.entity.Admin;
import com.bank.utils.JpaUtils;


@Repository("admindao")
public class AdminDaoImpl implements AdminDao {


private EntityManager manager;
	

public AdminDaoImpl(EntityManager manager) {
		this.manager=manager;
	}

public AdminDaoImpl() {
	manager = JpaUtils.getEntityManager();
		 
}
	@Override
	public boolean authenticate(Admin admin1) {
		
		Admin adminFound=manager.find(Admin.class, admin1.getAdmin_Id());
		boolean flag;
		if(adminFound==null)
		{
			flag=false;
		}
		else
		{
			if(adminFound.getPassword().matches(admin1.getPassword()))
					{
				flag=true;
					}
			else
			{
				flag=false;
			}
		}
		return flag;
	}

}
