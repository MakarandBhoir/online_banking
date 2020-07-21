import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/Model/customer';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service ';
import { StoreService } from 'src/app/Services/store.service';

@Component({
  selector: 'app-customer-check',
  templateUrl: './customer-check.component.html',
  styleUrls: ['./customer-check.component.css']
})
export class CustomerCheckComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';
  cust:Customer =new Customer();
  usertype:string;
  msg:string='';

  constructor( 
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private usersrv:UserService,
    public store: StoreService) {
      this.msg="";
     }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      cust_Id: ['', Validators.required],
      
  });

  // get return url from route parameters or default to '/'
  this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }
  get f() { return this.loginForm.controls; }

  onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.loginForm.invalid) {
          return;
      }

      this.loading = true;

      this.cust.customer_Id=this.f.cust_Id.value;
      alert(this.cust.customer_Id);
      localStorage.setItem("custIdL",""+this.cust.customer_Id); 
      this.checkCustExist();
    
     /* this.usersrv.isCustomerRegistered(this.cust.customer_Id)
      .subscribe(
data => {
  //  this.router.navigate([this.returnUrl]);
    this.msg=JSON.stringify(data);
 //alert(data);
   if(data === 'Yes')
   {  
    this.store.regCustId=this.cust.customer_Id;
    localStorage.setItem("data","this.cust.customer_Id");
    alert('You are already registered for INTERNET BANKING. ');
       this.router.navigate(['login']);
   }
   else{
     this.checkCustExist();
   }
},
error => {
 
    this.error = error;
    this.loading = false;
   // alert('You are not valid Customer.');
    //this.router.navigate(['home']);
});*/
}



checkCustExist(){

      this.usersrv.checkCustomer(this.cust.customer_Id)
                      .subscribe(
                data => {
                  //  this.router.navigate([this.returnUrl]);
                    this.msg=JSON.stringify(data);
                 //alert(data);
                   if(data === 'Yes')
                   {  
                    this.store.regCustId=this.cust.customer_Id;
                    localStorage.setItem("custIdL",""+this.cust.customer_Id); 
                    alert('OTP sent on your registered Mobile Number.');
                       this.router.navigate(['register']);
                   }
                   else{
                     alert('You are not valid Customer.');
                     this.router.navigate(['home']);
                   }
                },
                error => {
                 
                    this.error = error;
                    this.loading = false;
                   // alert('You are not valid Customer.');
                    //this.router.navigate(['home']);
                });
              }
            }

            
            
