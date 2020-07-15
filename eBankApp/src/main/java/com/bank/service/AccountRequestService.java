package com.bank.service;

import java.util.List;

import com.bank.entity.AccountRequest;

public interface AccountRequestService {
	
	public boolean addAccountRequest(AccountRequest accntreq);
	public void updateAccountStatus(String acctapvstatus,Long acctreqid,String remark);
	public List<AccountRequest> viewAllaccountrequest();
	public AccountRequest viewAccountrequestById(Long acctreq);
}
