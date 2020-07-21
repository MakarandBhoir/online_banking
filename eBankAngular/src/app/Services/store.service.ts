import { Injectable } from '@angular/core';
import { EBankUsers } from '../Model/ebank-users';

@Injectable({
  providedIn: 'root'
})
export class StoreService {
  public loginStatus = 0; // 0 = not logged in, 1 = logged in
  public usertype=0;
  public user_Id:String="";
  public user:EBankUsers=null;
public regCustId:number;


  setLoginStatus(status: number,type:number) {
    this.loginStatus = status;
    this.usertype=type;
    
  }
}
