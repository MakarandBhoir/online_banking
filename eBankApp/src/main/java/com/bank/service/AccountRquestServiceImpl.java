package com.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountRequestDao;
import com.bank.entity.AccountRequest;

@Service
public class AccountRquestServiceImpl implements AccountRequestService {
	
	@Autowired
	private AccountRequestDao acctdao;

	@Override
	public boolean addAccountRequest(AccountRequest accntreq) {
		Long result;
        acctdao.beginTransaction();
        result=acctdao.addAccountRequest(accntreq);
        acctdao.commitTransaction();
        if(result!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
	}

	@Override
	public void updateAccountStatus(String acctapvstatus, Long acctreqid, String remark) {
		acctdao.beginTransaction();
		acctdao.updateAccountStatus(acctapvstatus, acctreqid, remark);
		acctdao.commitTransaction();
		
	}

	@Override
	public List<AccountRequest> viewAllaccountrequest() {
		List<AccountRequest> listactrq=new ArrayList<AccountRequest>();
		listactrq=acctdao.viewAllaccountrequest();
		
		return listactrq;
	}

	@Override
	public AccountRequest viewAccountrequestById(Long acctreqid) {
		AccountRequest act=new AccountRequest();
		act=acctdao.viewAccountrequestById(acctreqid);
		return act;
	}
	
	
		
		
		

}
