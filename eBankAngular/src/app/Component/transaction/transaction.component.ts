import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators,FormControl,FormGroupName,FormsModule } from '@angular/forms';
import {UserTransactions} from 'src/app/Model/user-transactions';
import { BankAccount} from 'src/app/Model/bank-account';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service ';
import { StoreService } from 'src/app/Services/store.service';
import { Beneficiary } from 'src/app/Model/beneficiary';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  transForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';
  transreq: UserTransactions = new UserTransactions();
  bankAC:BankAccount[];
  payees:Beneficiary[];
  myACNo:number[];
  toACNo:number[];
  fromACNo:number;
  t_Pin:string;
  custId:number;
  
  


  constructor(
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      private userService: UserService,
      private store: StoreService
  ) { }

  ngOnInit() {
     
      this.transForm = this.formBuilder.group({
        from_AC:[''],
        to_AC:[''],
        amount:['',Validators.required],
        mode:[''],
        t_Pin:[''],
        
              });

      
      this.custId=parseInt(localStorage.getItem("custIdL"));
      console.log("cust "+localStorage.getItem("custIdL"));
     //retreiving self accounts
      this.userService.getmyBankAC(this.custId)
      .subscribe(data => {
         this.bankAC = data;
         this.myACNo = this.bankAC.map((item) => {
           return item.account_No;
         })
         console.log(this.myACNo);
      }, error => console.log(error));



       //retreiving self accounts
       this.userService.getmyPayeeAC(localStorage.getItem("user_IdL"))
       .subscribe(data => {
          this.payees = data;
          
          this.toACNo = this.payees.map((item) => {
            return item.payeeACno;
          })
          console.log(this.toACNo);
       }, error => console.log(error));

    
      // get return url from route parameters or default to '/'
      this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';

      
  }

  // convenience getter for easy access to form fields
  get f() { return this.transForm.controls; }

  
  onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.transForm.invalid) {
          return;

      }


      this.loading = true;
      alert("From AC "+this.f.from_AC.value);
      alert("TO "+this.f.to_AC.value);
      this.transreq.from_AC=this.f.from_AC.value;
      this.fromACNo=this.f.from_AC.value;
      this.transreq.to_AC=this.f.to_AC.value;
      this.transreq.amount=this.f.amount.value;
      this.transreq.mode=this.f.mode.value;
      this.transreq.user_Id=localStorage.getItem("user_IdL");
      
      this.t_Pin=this.f.t_Pin.value;
alert(""+this.f.from_AC.value);
      this.initiateTransaction();
    }
   

    initiateTransaction(){
      this.userService.requestTransaction(this.transreq,this.t_Pin,this.fromACNo)
          .subscribe(
              data => {
                  alert(data);
                 
                  this.router.navigate(['userHome']);
              },
              error => {

                  this.error = error;
                 // alert(JSON.stringify(this.error));
                  this.loading = false;
              });
      
  }

}