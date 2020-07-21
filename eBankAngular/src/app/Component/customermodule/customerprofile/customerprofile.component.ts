import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/Services/user.service ';
import { StoreService } from 'src/app/Services/store.service';
import {  Customer } from 'src/app/Model/customer';
@Component({
  selector: 'app-customerprofile',
  templateUrl: './customerprofile.component.html',
  styleUrls: ['./customerprofile.component.css']
})
export class CustomerprofileComponent implements OnInit {
  cust:Customer=new Customer();
  custid:string;
  error="";
  constructor(private usersrv: UserService,
    public store: StoreService) { }
  ngOnInit(): void {

   //console.log("customer id "+this.store.customer_Id)

   //alert(sessionStorage.getItem("customerid"));
   
  // this.custid=JSON.stringify(sessionStorage.getItem("customerid"));
  // console.log("sesion cust id" +this.custid);

   this.usersrv.viewProfile(parseInt(localStorage.getItem("custIdL")))
    .subscribe(
      data => {
        //  this.router.navigate([this.returnUrl]);
            
            this.cust=data;
            alert("indside data");
            
      },
      error => {
          this.error = error;
          alert("error occured "+error);
      });

   }

   accountDetails()
   {
     alert("inside acount details");
   }

  
  
  
}
