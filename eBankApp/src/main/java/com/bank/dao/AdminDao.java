package com.bank.dao;

import org.springframework.stereotype.Component;

import com.bank.entity.Admin;

public interface AdminDao {
	public boolean authenticate(Admin admin1);
}
