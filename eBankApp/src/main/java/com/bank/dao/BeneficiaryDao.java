package com.bank.dao;


import java.util.List;

import com.bank.entity.Beneficiary;

public interface BeneficiaryDao {
	public String addBeneficiary(Beneficiary beneficiary1);
	//public String checkBeneficiary(Beneficiary beneficiary1);
	public String editBeneficiary(Beneficiary beneficiary1);
	public Boolean removeBeneficiaryById(long payeeAC_No,String user_Id);
	public List<Beneficiary> getBeneficiaryByUserId(String user_Id);
	public Beneficiary getBeneficiaryByBId(int b_Id);
}
