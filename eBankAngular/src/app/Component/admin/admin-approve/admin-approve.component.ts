import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,FormControl, FormGroupDirective,Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountRequest } from 'src/app/Model/account-request';
import { AdminService } from 'src/app/Services/admin.service';
import { StoreService } from 'src/app/Services/store.service';

@Component({
  selector: 'app-admin-approve',
  templateUrl: './admin-approve.component.html',
  styleUrls: ['./admin-approve.component.css']
})
export class AdminApproveComponent implements OnInit {
    loginForm: FormGroup;
    accountreq: AccountRequest;
    loading = false;
    error = '';
  submitted = false;
  id:number;
  remark:string;
  status:string;
  constructor(
    private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        public store: StoreService,  
    private adminService: AdminService,
    ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      application_Id:[''],
      first_Name: [''],
      middle_Name: [''],
      last_Name: [''],
      father_Name: [''],
      dob: [''],
      email: [''],
      phone: [''],
      occupation_Type: [''],
      income_Source: [''],
      acct_type:[''],
      gross_Income: [''],
      adhar_No: [''],
      pan_No: [''],
      permanant_Address: [''],
      residential_Address: [''],
      apply_Date: [''],
      status:[''],
      remark:['']
  });

    this.accountreq = new AccountRequest();
    this.submitted = false;
    this.id = this.route.snapshot.params['id'];
    
    this.adminService.getAccountReqById(this.id)
      .subscribe(data => {
        console.log(data)
        this.accountreq = data;
      }, error => console.log(error));
  }

  newAccountRequ(): void {
    this.submitted = false;
    this.accountreq = new AccountRequest();
  }


  get f() { return this.loginForm.controls; }
  

  onSubmit() { console.log("inside submits");
    this.submitted = true;
    this.loading=true;
    this.id=this.f.application_Id.value;
    console.log("hhhhhh :"+this.id);
    this.status=this.f.status.value;
    this.remark=this.f.remark.value;
        this.updateAccountReq();    
  }
 
  updateAccountReq() { console.log(" id "+this.id+" "+this.status);
    this.adminService.updateAccountReqStatus(this.id,this.status,this.remark)
      .subscribe(data => console.log(data), error => console.log(error));
    

    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['ACrequest']);
  }
}
