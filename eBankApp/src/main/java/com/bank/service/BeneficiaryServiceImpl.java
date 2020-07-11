package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bank.dao.BeneficiaryDao;
import com.bank.dao.BeneficiaryDaoImpl;
import com.bank.entity.Beneficiary;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	@Qualifier("beneficiarydao")
	BeneficiaryDao beneficiarydao;

	public BeneficiaryServiceImpl() {
	}

	@Override
	public String addBeneficiary(Beneficiary beneficiary1) {
		String msg="";
		
		msg = beneficiarydao.addBeneficiary(beneficiary1);
		
		return msg;
		
	}
	
	
	
	@Override
	public String editBeneficiary(Beneficiary beneficiary1) {
		String msg="";
		
		msg = beneficiarydao.editBeneficiary(beneficiary1);
		
		return msg;
		
	}

	@Override
	public String removeBeneficiary(long payeeACno,String user_Id) {
		String msg="";
		Boolean flag=beneficiarydao.removeBeneficiaryById(payeeACno,user_Id);
		if(flag==true)
			msg="Beneficiary removed!";
			else
				msg="There is problem removing beneficiary! ";
		return msg;
	}

	@Override
	public List<Beneficiary> getBeneficiaryByUserId(String user_Id) {
		List<Beneficiary> payeeList = beneficiarydao.getBeneficiaryByUserId(user_Id);
		return payeeList;
	}
	
	@Override
	public Beneficiary getBeneficiaryByBId(int b_Id) {
		Beneficiary payee = beneficiarydao.getBeneficiaryByBId(b_Id);
		return payee;
	}

}
