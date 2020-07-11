package com.bank.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.bank.entity.Beneficiary;
import com.bank.service.BeneficiaryService;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

@RestController
@RequestMapping(path = "/payee")
public class BeneficiaryController {
	
@Autowired
private BeneficiaryService beneficiaryservice;

@Autowired
private ApplicationContext context;


@GetMapping(value="getbyUID/{user_Id}",produces="application/json")
@ResponseBody
//@CrossOrigin(origins="http://localhost:4200")
public List<Beneficiary> getBeneficiaryListByUser_Id(@PathVariable("user_Id") String user_Id) {
	return beneficiaryservice.getBeneficiaryByUserId(user_Id);
}

@GetMapping(value="getbyBID/{b_Id}",produces="application/json")
@ResponseBody
//@CrossOrigin(origins="http://localhost:4200")
public Beneficiary getBeneficiaryListByB_Id(@PathVariable("b_Id") int b_Id) {
	return beneficiaryservice.getBeneficiaryByBId(b_Id);
}


@PostMapping(value="/add",consumes = "application/json")
@ResponseBody
//@CrossOrigin(origins="http://localhost:4200")
String saveBeneficiary(@RequestBody Beneficiary beneficiary1) {
	
	String msg=beneficiaryservice.addBeneficiary(beneficiary1);
	
	
	return msg;
	
}

@PostMapping(value="/update",consumes = "application/json")
@ResponseBody
//@CrossOrigin(origins="http://localhost:4200")
String editBeneficiary(@RequestBody Beneficiary beneficiary1) {
	
	return beneficiaryservice.editBeneficiary(beneficiary1);
	
}

@GetMapping(path="/remove/{payeeACno}/{user_Id}")
@ResponseBody
//@CrossOrigin(origins="http://localhost:4200")
String deleteBeneficiary(@PathVariable("payeeACno")Long payeeACno,@PathVariable("user_Id") String user_Id) {
	System.out.println("Delete ..");
	
	return beneficiaryservice.removeBeneficiary(payeeACno,user_Id);
	
}

@GetMapping("/home")
public void show()
{
	System.out.println("this is show");
}






}
