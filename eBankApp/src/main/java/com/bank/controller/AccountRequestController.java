package com.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.AccountRequest;
import com.bank.service.AccountRequestService;

@RestController
@RequestMapping(path = "requestAccount")
public class AccountRequestController {

	@Autowired
	private AccountRequestService acctsrv;

	
	@PostMapping(value = "/registerAcct", consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    @CrossOrigin(origins="http://localhost:4200")
    public ResponseEntity<String>  accountRequest(@RequestBody AccountRequest acctreq) {
        System.out.println("inside account rest controller"+acctreq.toString());
        ResponseEntity<String> response;
        String msg;
        boolean result=acctsrv.addAccountRequest(acctreq);
        System.out.println("result is "+result);
        if(result=true)
        {
            msg="saved";
        }
        else
        {
            msg="failed";
        }

 
        ResponseEntity<String> obj=new ResponseEntity(msg,HttpStatus.OK);
        return obj;
        
    }
 


	
	@PutMapping(path = "updateStatus/{appid}/{status}/{remark}")
	@CrossOrigin(origins="http://localhost:4200")
	public void updateStatus(@PathVariable("status") String acctapvstatus,@PathVariable("appid") Long appreqid,@PathVariable("remark") String remark)
	{
		System.out.println("acctapvstatus "+acctapvstatus+" acctreqid "+appreqid+" remark"+remark);
		acctsrv.updateAccountStatus(acctapvstatus, appreqid, remark);
	
	}

	@GetMapping(path = "/viewAcctreq")
	@CrossOrigin(origins="http://localhost:4200")
	public List<AccountRequest> viewAllaccountrequest()
	{
		List<AccountRequest> listactrq=new ArrayList<AccountRequest>();
		listactrq=acctsrv.viewAllaccountrequest();
		
		return listactrq;
		
	}
	
	@GetMapping(path = "/viewAcctreqById/{acctreqid}")
	@ResponseBody
	@CrossOrigin(origins="http://localhost:4200")
	public AccountRequest viewAccountrequestById(@PathVariable("acctreqid") Long acctreqid)
	{
		AccountRequest acctreq=new AccountRequest();
		acctreq=acctsrv.viewAccountrequestById(acctreqid);
		return acctreq;
		
	}
	
}
