import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserTransactions } from 'src/app/Model/user-transactions';
import { BankAccount } from 'src/app/Model/bank-account';
import { UserService } from 'src/app/Services/user.service ';

@Component({
  selector: 'app-accountsummary',
  templateUrl: './accountsummary.component.html',
  styleUrls: ['./accountsummary.component.css']
})
export class AccountsummaryComponent implements OnInit {
  //bnkacct:BankAccount=new BankAccount();
  urstran: UserTransactions[];

  bnkacct: BankAccount[];
  show: boolean = false;
  custid:string;
  error = '';
  constructor(private usersrv: UserService) { }

  ngOnInit(): void {

    this.custid=sessionStorage.getItem("customerid");
    alert(this.custid);
    this.usersrv.viewAllBankAccounts(1)
      .subscribe(
        data => {
          //  this.router.navigate([this.returnUrl]);

          this.bnkacct = data;
          //alert("indside data"+this.bnkacct[0].account_No);
          console.log("data ", data);
        },
        error => {
          this.error = error;
          alert("error occured " + error);
        });
  }


  viewLast10Transac(acctno: string) {
    this.show = true;
    alert("account no is " + acctno);

    this.usersrv.getlast10transaction(acctno)
      .subscribe(
        data => {
          //  this.router.navigate([this.returnUrl]);

          this.urstran = data;
          //alert("indside data" + this.urstran[0].amount);

        },
        error => {
          this.error = error;
          alert("error occured " + error);
        });
    console.log()
  }



}
