import { Injectable } from '@angular/core';
import { AccountRequest } from "../Model/account-request";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  
  private baseUrl = 'http://localhost:8091/eBankingApp/requestAccount';

  private path;

  constructor(private http:HttpClient) {  }


  registerAcctRequest(acctrq: AccountRequest): Observable<any> {
    this.path =this.baseUrl+"/registerAcct";
    return this.http.get(`${this.path}`);
  }



 

  getAccountReqById(id:number):Observable<any>
  {
    return this.http.get(`${this.baseUrl}/viewAcctreqById/${id}`);
  }


  updateAccountReqStatus(appid:number,status:string,remark:string):Observable<any>
  {this.path =this.baseUrl+"/updateStatus/";
    return this.http.put(`${this.path}/${appid}/${status}/${remark}`, {})   //${this.path}/${appid}/${status}/${remark}
  }

  getallAccounts(): Observable<any>
  {
    return this.http.get(`${this.baseUrl}/viewAcctreq`);
  }




}
