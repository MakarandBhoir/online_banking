package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.catalina.Manager;
import org.springframework.stereotype.Repository;

import com.bank.entity.Beneficiary;
import com.bank.entity.Customer;
import com.bank.utils.JpaUtils;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private EntityManager manager;

	public CustomerDaoImpl() {
		manager = JpaUtils.getEntityManager();
	}

	@Override
	public Customer viewProfile(Long custid) {
		Customer custprofile = new Customer();
		String query = "from Customer c where c.customer_Id =" + custid;
		custprofile = (Customer) manager.createQuery(query).getSingleResult();
		System.out.println(custprofile.toString());
		return custprofile;

	}

	@Override
	public void viewAccountSummary() {
		// TODO Auto-generated method stub

	}

	@Override
	public void vewAccountDetails() {
		// TODO Auto-generated method stub

	}

}
