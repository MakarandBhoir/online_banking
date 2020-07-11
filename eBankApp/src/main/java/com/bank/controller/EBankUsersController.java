package com.bank.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.bank.entity.Admin;
import com.bank.entity.EBankUsers;
import com.bank.service.AdminService;
import com.bank.service.EBankUsersService;

@RestController
@RequestMapping(path = "/user")
public class EBankUsersController {
	
@Autowired
private EBankUsersService userservice;

@Autowired
private ApplicationContext context;

@PostMapping(value = "/login",consumes = "application/json")
@ResponseBody
public String  loginUser(@RequestBody EBankUsers user1) {
	System.out.println("inside USER rest controller"+user1.toString());
	
	String msg=userservice.authenticateUser(user1);
	return msg;
}

@PostMapping(value = "/register",consumes = "application/json")
@ResponseBody
public String  activateInternetBanking(@RequestBody EBankUsers user1) {
	System.out.println("inside USER rest controller"+user1.toString());
	
	String msg=userservice.registerUser(user1);
	return msg;
}
 
@GetMapping("/home")
public void show()
{
	System.out.println("this is show");
}






}
