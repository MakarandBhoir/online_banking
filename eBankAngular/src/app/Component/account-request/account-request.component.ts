import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service ';
import { AccountRequest } from 'src/app/Model/account-request';

@Component({
    selector: 'app-account-request',
    templateUrl: './account-request.component.html',
    styleUrls: ['./account-request.component.css']
})
export class AccountRequestComponent implements OnInit {
    acctReqForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    error = '';
    acctreq: AccountRequest = new AccountRequest();


    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private usersrv: UserService
    ) { }

    ngOnInit() {
       
        this.acctReqForm = this.formBuilder.group({
            firstName: ['',[Validators.required,Validators.pattern("^[a-zA-Z]*$")]],
            middleName: ['',[Validators.required,Validators.pattern("^[a-zA-Z]*$")]],
            lastName: ['',[Validators.required,Validators.pattern("^[a-zA-Z]*$")]],
            fatherName: ['',[Validators.required,Validators.pattern("^[a-zA-Z]*$")]],
            dob: ['',[Validators.required]],
            email: ['',[Validators.required, Validators.email]],
            phone: ['',[Validators.required,Validators.pattern("^[0-9]*$")]],
            occupation_Type: ['',[Validators.required]],
            income_Source: ['',[Validators.required]],

           acct_type:['Savings',[Validators.required,Validators.pattern("^[a-zA-Z]*$")]],
            gross_Income: ['',[Validators.required]],
            adhar_No: ['',[Validators.required,Validators.pattern("^[0-9]*$")]],
            pan_No: ['',[Validators.required]],
            permanant_Address: ['',[Validators.required]],
            residential_Address: ['',[Validators.required]],
         });

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    // convenience getter for easy access to form fields
    get f() { return this.acctReqForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.acctReqForm.invalid) {
            return;
        }

        this.loading = true;
        this.acctreq.adhar_No = this.f.adhar_No.value;

       // alert("adhar card value " + this.f.adhar_No.value);
       // alert("last card value " + this.f.lastName.value);
        this.acctreq.last_Name = this.f.lastName.value;
        this.acctreq.first_Name=this.f.firstName.value;
        this.acctreq.gross_Income = this.f.gross_Income.value;
        this.acctreq.father_Name=this.f.fatherName.value;
        this.acctreq.income_Source= this.f.income_Source.value;
        this.acctreq.middle_Name=this.f.middleName.value;
        this.acctreq.occupation_Type= this.f.occupation_Type.value;
        this.acctreq.pan_No=this.f.pan_No.value;
        this.acctreq.permanant_Address=this.f.permanant_Address.value;
        this.acctreq.residential_Address=this.f.residential_Address.value;
        this.acctreq.phone=this.f.phone.value;
        this.acctreq.dob=this.f.dob.value;
        this.acctreq.email=this.f.email.value;
        this.acctreq.acct_type=this.f.acct_type.value;
      //  alert(this.f.acct_type.value);
        this.usersrv.registerAcctRequest(this.acctreq)
            .subscribe(
                data => {
                   
                    alert("You New Account Request Registered !!");
                    console.log("data " + data);
                    console.log(this.returnUrl);
                    this.router.navigate(['home']);
                },
                error => {

                    this.error = error;
                   // alert(JSON.stringify(this.error));
                    this.loading = false;
                });
        /*  this.authenticationService.login(this.f.username.value, this.f.password.value)
              .pipe(first())
              .subscribe(
                  data => {
                      this.router.navigate([this.returnUrl]);
                  },
                  error => {
                      this.error = error;
                      this.loading = false;
                  });
      }*/
    }

}

