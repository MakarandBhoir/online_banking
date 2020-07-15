package com.bank.dao;

import java.util.List;

import com.bank.entity.AccountRequest;

public interface AccountRequestDao {
	
	public Long addAccountRequest(AccountRequest accntreq);
	public void updateAccountStatus(String acctapvstatus,Long acctreqid,String remark);
	public void beginTransaction();
	public void commitTransaction();
	public List<AccountRequest> viewAllaccountrequest();
	public AccountRequest viewAccountrequestById(Long acctreqid);
	

}
