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
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping(path = "/user")
public class EBankUsersController {

	@Autowired
	private EBankUsersService userservice;

	@Autowired
	private ApplicationContext context;

	@PostMapping(value = "/login", consumes = "application/json")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> loginUser(@RequestBody EBankUsers user1) {

		String msg = userservice.authenticateUser(user1);

		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@PostMapping(value = "/register", consumes = "application/json")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public String activateInternetBanking(@RequestBody EBankUsers user1) {

		String msg = userservice.registerUser(user1);
		return msg;
	}

	@GetMapping("/home")
	public void show() {
		System.out.println("this is show");
	}

}
