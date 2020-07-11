package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.hql.internal.ast.tree.IsNullLogicOperatorNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.entity.Admin;
import com.bank.entity.Beneficiary;
import com.bank.utils.JpaUtils;

@Repository("beneficiarydao")
public class BeneficiaryDaoImpl  implements BeneficiaryDao{

	private EntityManager manager;

	public BeneficiaryDaoImpl() {
		manager = JpaUtils.getEntityManager();
		System.out.println(" ....manager created");
	}

	@Override
	public String addBeneficiary(Beneficiary ben1) {
		
		boolean ben_Id=false;
		String msg="";
		 Query query = manager.createQuery("select b.b_Id FROM Beneficiary b WHERE b.payeeACno="+ ben1.getPayeeACno()+" AND b.user_Id='"+ ben1.getUser_Id() +"'");
	     ben_Id = query.getResultList().isEmpty();
	    System.out.println(ben_Id);
	    if(ben_Id==true) {
		manager.getTransaction().begin();
		manager.persist(ben1);
		manager.getTransaction().commit();
		msg= "Beneficiary added successfully!";
	}
	    else {
	    	
	    msg="Beneficiary already exists! Do you want to overwrite?";
	    }
	    return msg;
	    }

	@Override
	public String editBeneficiary(Beneficiary ben1) {
		String msg="";
		Query query = manager.createQuery("select b.b_Id FROM Beneficiary b WHERE b.payeeACno="+ ben1.getPayeeACno()+" AND b.user_Id='"+ ben1.getUser_Id() +"'");
		String ben_Id = query.getSingleResult().toString();
		System.out.println(ben_Id);
		int b=Integer.parseInt(ben_Id);
		System.out.println(b);
		Beneficiary oldPayee = manager.find(Beneficiary.class,b);
		System.out.println(oldPayee); 
		oldPayee.setBankName(ben1.getBankName());
		oldPayee.setIfsc(ben1.getIfsc());
		oldPayee.setPayeeACno(ben1.getPayeeACno());
		oldPayee.setNickName(ben1.getNickName());
		System.out.println(oldPayee.toString());
		
		manager.getTransaction().begin();
		manager.persist(oldPayee);
		manager.getTransaction().commit();
		msg= "Beneficiary updated successfully!";
		return msg;
	}
	

	
	@Override
	public Boolean removeBeneficiaryById(long payeeACno,String user_Id) {
		int b_Id;
		Boolean flag;
		
		 Query query = manager.createQuery("SELECT  b.b_Id FROM Beneficiary b WHERE b.payeeACno="+ payeeACno+"  AND b.user_Id='"+ user_Id+"'");
	    System.out.println("dao delete");
		 
		 b_Id = (int) query.getSingleResult();
		 System.out.println(b_Id);
	    if(b_Id==0) {
	    	flag=false;
	    }
	    else {
		Beneficiary Payee = manager.find(Beneficiary.class, b_Id);
		
		  manager.getTransaction().begin();
		  manager.remove(Payee);
		  manager.getTransaction().commit();
		  flag=true;
		}
		  return flag;

	}

	@Override
	public List<Beneficiary> getBeneficiaryByUserId(String user_Id) {
		List<Beneficiary> payeeList=new ArrayList<Beneficiary>();
		
        String hql = "from Beneficiary b where b.user_Id like '"+user_Id+"'";
		 
		
		payeeList = manager.createQuery(hql).getResultList();
				
		System.out.println("Payee List"+payeeList.toString());
		
		
return payeeList;
	}

	@Override
	public Beneficiary getBeneficiaryByBId(int b_Id) {
		String hql = "from Beneficiary b where b.b_Id ="+b_Id+"";
		 
		
		Beneficiary payee = (Beneficiary) manager.createQuery(hql).getSingleResult();
		
		return payee;
	}
}
