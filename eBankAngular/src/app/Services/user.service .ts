import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EBankUsers } from "../Model/ebank-users";
import { Beneficiary } from "../Model/beneficiary";
import { Admin } from '../Model/Admin';
import { AccountRequest } from '../Model/account-request';
import { UserTransactions } from '../Model/user-transactions';
import { BankAccount } from '../Model/bank-account';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8091/eBankingApp';
  private path;

  constructor(private http:HttpClient) {  }

  viewProfile(custid:number): Observable<any>
  {
    this.path =this.baseUrl+"/Customer/viewProfile/"+custid;
    return this.http.get(`${this.path}`);
  }
  checkCustomer(custid:number): Observable<any>
  {
    this.path =this.baseUrl+"/Customer/check/"+custid;
    return this.http.get(`${this.path}`,{responseType: 'text'});
  }
/*
  isCustomerRegistered(custid:number): Observable<any>
  {
    this.path =this.baseUrl+"/Customer/check/"+custid;
    return this.http.get(`${this.path}`,{responseType: 'text'});
  }*/

  registerUser(user:EBankUsers): Observable<any>
  {
    this.path =this.baseUrl+"/user/register/";
    return this.http.post(`${this.path}`,user,{responseType: 'text'});
  }

 /* viewAllBankAccounts(custid:number): Observable<any>
  {
    this.path =this.baseUrl+"/bankAcct/viewAcct/"+custid;
    return this.http.get(`${this.path}`);
  }*/
  viewAllBankAccounts(custid:number): Observable<any>
  {
    this.path =this.baseUrl+"/bankAcct/viewAcct/"+custid;
    return this.http.get(`${this.path}`);
  }
  checklogin(user: EBankUsers): Observable<any> {
    this.path =this.baseUrl+"/user/login";
    console.log("baseurl "+this.baseUrl);
    console.log("path  "+this.path);
    return this.http.post(`${this.path}`, user,{responseType: 'text'});
  }

  checkAdminlogin(admin: Admin): Observable<any> {
    this.path =this.baseUrl+"/admin/login";
    console.log("baseurl "+this.baseUrl);
    console.log("path  "+this.path);
    return this.http.post(`${this.path}`, admin,{responseType: 'text'});
  }

  viewBankAccountById(acctid:number,custid:number): Observable<any>
  {
    this.path =this.baseUrl+"/bankAcct/viewAcctbyid/"+custid+"/"+acctid;
    return this.http.get(`${this.path}`);
  }

  registerAcctRequest(acctrq: AccountRequest): Observable<any> {
    this.path =this.baseUrl+"/requestAccount/registerAcct";
    return this.http.post(`${this.path}`,acctrq,{responseType: 'text'});
  }

  getallPayeesByUID(userid:String): Observable<any>
  {

    this.path =this.baseUrl+"/payee/getbyUID/"+userid;
    return this.http.get(`${this.path}`);
  }
deletePayee(b_Id:number): Observable<any>
{
  this.path =this.baseUrl+"/payee/remove/"+b_Id;
  return this.http.delete(`${this.path}`,{responseType: 'text'});

}

updatePayee(payee:Beneficiary): Observable<any>
{
  this.path =this.baseUrl+"/payee/update/";
  return this.http.post(`${this.path}`,payee,{responseType: 'text'});

}

getPayee(b_Id:number): Observable<any>
{
  this.path =this.baseUrl+"/payee/getbyBID/"+b_Id;
  return this.http.get(`${this.path}`);

}

createPayee(payee:Beneficiary): Observable<any>
{
  this.path =this.baseUrl+"/payee/add/";
  
  return this.http.post(`${this.path}`,payee,{responseType: 'text'});

}

requestTransaction(t1:UserTransactions,t_Pin:string,myAC_No:number): Observable<any>
{
  this.path =this.baseUrl+"/transaction/request/"+t_Pin+"/"+myAC_No+"/";
  
  return this.http.post(`${this.path}`,t1,{responseType: 'text'});

}

getmyBankAC(custId:number): Observable<any>
{
  this.path =this.baseUrl+"/bankAcct/viewAcct/"+custId;
  
  return this.http.get(`${this.path}`);

}
getmyPayeeAC(UID:String): Observable<any>
{
  this.path =this.baseUrl+"/payee/getbyUID/"+UID;
  console.log(this.path);
  return this.http.get(`${this.path}`);

}
getMiniStatement(acNo:number): Observable<any>
{
  this.path =this.baseUrl+"/transaction/getStatement/"+acNo;
  
  return this.http.get(`${this.path}`);

}
getlast10transaction(acctid:string): Observable<any>
{

  this.path =this.baseUrl+"/transaction/getStatement/"+acctid;
  return this.http.get(`${this.path}`);
}

}
