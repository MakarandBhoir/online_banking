import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Admin } from 'src/app/Model/Admin';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service ';
import { StoreService } from 'src/app/Services/store.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

 
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    error = '';
    admin:Admin =new Admin();
    usertype:string;
    msg:string;
    

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private usersrv:UserService,
        public store: StoreService
         ) 
    {
      this.usertype="admin";
  this.msg="";
  }

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

        this.admin.admin_Id=this.f.username.value;
        this.admin.password=this.f.password.value;
        //this.usertype=this.f.type.value;

       this.usersrv.checkAdminlogin(this.admin)
                      .subscribe(
                data => { alert(data);
                  this.msg=data;
                   
                  localStorage.setItem("userTypeL",'1');
                  localStorage.setItem("loginStatusL",'1');
                    this.router.navigate([this.returnUrl]);
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });

               
    }
}


