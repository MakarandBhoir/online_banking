import { Component, OnInit } from '@angular/core';
import { UserTransactions } from 'src/app/Model/user-transactions';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/Services/user.service ';
import { Router, ActivatedRoute } from '@angular/router';
import { BankAccount } from 'src/app/Model/bank-account';
import { FormGroup, FormBuilder, Validators,FormControl } from '@angular/forms';

@Component({
  selector: 'app-mini-statement',
  templateUrl: './mini-statement.component.html',
  styleUrls: ['./mini-statement.component.css']
})
export class MiniStatementComponent implements OnInit {
  tForm: FormGroup;
  returnUrl: string;
  transactions: Observable<UserTransactions[]>;
  trans:UserTransactions;
  ACNo:number;
  custId:number;
  bankAC:BankAccount[];
  myAC:number[];
  get_AC:BankAccount;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
  
) { }

ngOnInit() {
   
    this.tForm = this.formBuilder.group({
      from_AC:[''],
                  });

 
    this.custId=parseInt(localStorage.getItem("custIdL"));
  
   //retreiving self accounts
    this.userService.getmyBankAC(this.custId)
    .subscribe(data => {
       this.bankAC = data;
       this.myAC = this.bankAC.map((item) => {
         return item.account_No;
       })
       console.log(this.myAC);
    }, error => console.log(error));

   
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';

  }
  

  // convenience getter for easy access to form fields
  get f() { return this.tForm.controls; }


  onSubmit(){
    this.get_AC.account_No=this.f.from_AC.value;
    this.ACNo=this.get_AC.account_No;
this.reloadData();

  }
  
  reloadData() {
  
    this.ACNo = this.f.from_AC.value;
		console.log(' Changed: ' + this.ACNo);
   this.transactions = this.userService.getMiniStatement(this.ACNo);

  }

}

 
  

