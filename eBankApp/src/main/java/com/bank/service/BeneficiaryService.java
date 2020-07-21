package com.bank.service;

import java.util.List;

import com.bank.entity.Beneficiary;

public interface BeneficiaryService {
	public String addBeneficiary(Beneficiary beneficiary1);
	//public String checkBeneficiary(Beneficiary beneficiary1);
	public String editBeneficiary(Beneficiary beneficiary1);
	public String removeBeneficiary(int b_Id);
	public List<Beneficiary> getBeneficiaryByUserId(String user_Id);
	public Beneficiary getBeneficiaryByBId(int b_Id);
}
