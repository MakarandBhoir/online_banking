import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { UserService } from 'src/app/Services/user.service ';
import { StoreService } from 'src/app/Services/store.service';
import { EBankUsers } from 'src/app/Model/ebank-users';
import { VirtualTimeScheduler } from 'rxjs';
import { MenuComponent } from '../menu/menu.component';



@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    error = '';
    user:EBankUsers =new EBankUsers();
    usertype:string;
    msg:string;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private usersrv:UserService,
        public store: StoreService
      
        
    ) 
    {this.usertype="user";

this.msg="";}

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
        console.log(this.returnUrl);
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
       

       this.usersrv.checklogin(this.user)
                      .subscribe(
                data => {
                 
                    this.msg=JSON.stringify(data);
                    
                    if(data=="Login Failed!")
                    { this.store.setLoginStatus(0,0);
                    alert('Login Failed')
                        this.router.navigate(['home']);
                    }
                    else{
                        alert('Login Successful!')
                        this.store.setLoginStatus(1,2);
                        this.store.user_Id=this.user.user_Id;
                        this.store.regCustId=data;
                       localStorage.setItem("user_IdL",this.user.user_Id);  
                       alert(this.user.user_Id);
                        localStorage.setItem("custIdL",data);  
                    
                        localStorage.setItem("userTypeL",'2');
                        localStorage.setItem("loginStatusL",'1');  
                        this.router.navigate(['userHome']);
                    }
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });

              
    }
   
    
}


