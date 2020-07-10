package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bank.dao.AdminDao;
import com.bank.dao.AdminDaoImpl;
import com.bank.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	@Qualifier("admindao")
	AdminDao admindao;
	
	public AdminServiceImpl() {}
	
	@Override
	public String authenticate(Admin admin1) {
		String msg="";
		boolean success=admindao.authenticate(admin1);
		if(success==true)
		{ 
						msg="Login Successful!";
		}
		else {
			msg="Login Failed!";
		}
		return msg;
	}

}
