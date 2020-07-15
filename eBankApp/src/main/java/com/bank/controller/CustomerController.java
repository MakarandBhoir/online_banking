package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.AccountRequest;
import com.bank.entity.Customer;
import com.bank.service.AccountRequestService;
import com.bank.service.CustomerService;

@RestController
@RequestMapping(path = "Customer")
public class CustomerController {

	@Autowired
	private CustomerService custsrv;

	@GetMapping(path = "viewProfile/{custid}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Customer viewProfile(@PathVariable("custid") Long custid) {

		Customer custpr = custsrv.viewProfile(custid);

		return custpr;

	}

	@GetMapping(path = "check/{custid}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String isValidCustomer(@PathVariable("custid") Long custid) {
		String msg = "";

		Customer custpr = custsrv.viewProfile(custid);
		if (custpr.getFirst_Name().isEmpty()) {
			msg = "No";
		} else {
			msg = "Yes";
		}

		return msg;

	}

}
