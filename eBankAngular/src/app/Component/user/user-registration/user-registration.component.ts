import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EBankUsers } from 'src/app/Model/ebank-users';
import { UserService } from 'src/app/Services/user.service ';
import { StoreService } from 'src/app/Services/store.service';


@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent  {
  loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    error = '';
    user:EBankUsers;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private usersrv:UserService,
        public store: StoreService,
      
    ) 
    {}

    ngOnInit() {
    this.user=new EBankUsers();
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['',[Validators.required, Validators.minLength(6)]],
            t_Pin: ['',[Validators.required, Validators.minLength(4)]],
            confirmpassword: ['',[Validators.required, Validators.minLength(6)]],
            confirmt_Pin: ['',[Validators.required, Validators.minLength(4)]],
        },
      //  {validator: this.passwordMatchValidator},
        );

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        this.user.user_Id=this.f.username.value;
        this.user.password=this.f.password.value;
        this.user.t_Pin=this.f.t_Pin.value;
        this.user.cust_Id=this.store.regCustId;
       this.usersrv.registerUser(this.user)
            
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                    if(data=="Registration Successful!")
                    { alert(data);
                        this.router.navigate(['login']);
                    }
                    else{
                        alert('Registration Failed! UserName/ Password are already in use.');
                      this.router.navigate(['home']);
                    }
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });
    }
}


