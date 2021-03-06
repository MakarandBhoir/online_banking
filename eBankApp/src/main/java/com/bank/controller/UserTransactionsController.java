package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.web.bind.annotation.*;

import com.bank.entity.UserTransactions;

import com.bank.service.UserTransactionsService;

@RestController
@RequestMapping(path = "/transaction")
public class UserTransactionsController {

	@Autowired
	private UserTransactionsService userTransactionsservice;

	@Autowired
	private ApplicationContext context;

	@PostMapping(value = "/request/{t_Pin}/{myAC_No}", consumes = "application/json")
	@ResponseBody
	@CrossOrigin(origins="http://localhost:4200")
	public String requestFundTransfer(@RequestBody UserTransactions t, @PathVariable("t_Pin") String t_Pin,@PathVariable("myAC_No")Long from_AC) {
		
		String msg = "";
		
		UserTransactions t1=userTransactionsservice.linkFrom_AC(t,from_AC);
		t1.getBankAC().setAccount_No(from_AC);
		
		if (t_Pin.equalsIgnoreCase(userTransactionsservice.getUserT_Pin(t1.getUser_Id()))) {
			
			Boolean flag = userTransactionsservice.isSufficientBalance(t1);
			if (flag ==true)
				msg = userTransactionsservice.initiateNewTransaction(t1);
			else
				msg = "Sorry ! You have insufficient Balance in your Account " + t1.getFrom_AC() + "";
		} else {
			msg = "Invalid Transaction Pin!";
		}
		t1.setStatus("Success");
		t1.setRemark("Valid Transaction");
		return msg = userTransactionsservice.completeTransaction(t1);
	}

	@PostMapping(value = "/updateStatus", consumes = "application/json")
	@ResponseBody
	@CrossOrigin(origins="http://localhost:4200")
	public String updateTransactionStatus(@RequestBody UserTransactions t1) {
		
		String msg = "";
		if (t1.getStatus().equalsIgnoreCase("Success")) {
			 msg = userTransactionsservice.completeTransaction(t1);
		}
		else if (t1.getStatus().equalsIgnoreCase("Pending"))
			{
				msg = "Processing Transaction!It will take some time!";
			}
			else if(t1.getStatus().equalsIgnoreCase("Fail"))
			{
				msg = userTransactionsservice.updateTransaction(t1);
		} else {
			msg = "Pending!";
		}
		return msg;
	}
	
	@GetMapping(value = "/getStatement/{myAC_No}", produces = "application/json")
	@ResponseBody
	@CrossOrigin(origins="http://localhost:4200")
	public List<UserTransactions> printRecentStatements(@PathVariable("myAC_No") Long fromAC_No) {
		
 
		List<UserTransactions> statement = userTransactionsservice.getMiniStatement(fromAC_No);
		return statement;
	}

	@GetMapping("/home")
	public void show() {
		System.out.println("this is show");
	}

}
