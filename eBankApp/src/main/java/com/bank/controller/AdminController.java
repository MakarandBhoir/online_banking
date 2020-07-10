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
import com.bank.service.AdminService;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
	
@Autowired
private AdminService adminservice;

@Autowired
private ApplicationContext context;

@PostMapping(value = "/login",consumes = "application/json")
@ResponseBody
public String  loginAdmin(@RequestBody Admin admin1) {
	System.out.println("inside admin rest controller"+admin1.toString());
	
	String msg=adminservice.authenticate(admin1);
	return msg;
}

@GetMapping("/home")
public void show()
{
	System.out.println("this is show");
}






}
