package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bank.dao.EBankUsersDao;
import com.bank.entity.EBankUsers;

@Service
public class EBankUsersServiceImpl implements EBankUsersService{

	@Autowired
	@Qualifier("userdao")
	EBankUsersDao userdao;
	
	public EBankUsersServiceImpl() {}
	
	@Override
	public String authenticateUser(EBankUsers user1) {
		String msg="";
		boolean success=userdao.authenticateUser(user1);
		if(success==true)
		{ 
						msg="Login Successful!";
		}
		else {
			msg="Login Failed!";
		}
		return msg;
	}

	

	@Override
	public String registerUser(EBankUsers user1) {
		String msg="";
		boolean success=userdao.registerUser(user1);
		if(success==true)
		{ 
			msg="Registration Successful!";
		}
		else {
			msg="Registration Failed!";
		}
		return msg;
	}

}
