import { Component, OnInit, Input } from '@angular/core';
import { Beneficiary } from 'src/app/Model/beneficiary';
import { UserService } from 'src/app/Services/user.service ';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder,FormControl, FormGroupDirective,Validators } from '@angular/forms';

@Component({
  selector: 'app-add-beneficiary',
  templateUrl: './add-beneficiary.component.html',
  styleUrls: ['./add-beneficiary.component.css']
})
export class AddBeneficiaryComponent implements OnInit {
  loginForm: FormGroup;
  payee: Beneficiary;
  submitted = false;
  id: number;
  loading = false;
  error = '';


  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {

    this.loginForm = this.formBuilder.group({
      payeeACno:[''],
      bankName: [''],
      ifsc: [''],
      nickName: [''],
  });
  
  
  this.payee = new Beneficiary();
  this.submitted = false;
  this.id = this.route.snapshot.params['id'];
  
    
    this.userService.getPayee(this.id)
      .subscribe(data => {
       
        this.payee = data;
        console.log(this.payee);
      }, error => console.log(error));
  }

  get f() { return this.loginForm.controls; }

  newBeneficiary(): void {
    this.submitted = false;
    this.payee = new Beneficiary();
  }

  save() {
    
    console.log("id  is :"+this.id);
   if(this.id===undefined)
   {
          this.createPayee();}
   else
   {
     this.updatePayee();}
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }
  createPayee() {
    this.payee.payeeACno=this.f.payeeACno.value;
    this.payee.bankName=this.f.bankName.value;
    this.payee.ifsc=this.f.ifsc.value;
    this.payee.nickName=this.f.nickName.value;
   
    this.payee.user_Id=localStorage.getItem('user_IdL');
    this.payee.b_Id=0;
    
    this.userService.createPayee(this.payee)
      .subscribe(data => console.log(data), error => console.log(error));
  //  this.payee = new Beneficiary();
    this.gotoList();
  }
  updatePayee() {
    this.userService.updatePayee(this.payee)
      .subscribe(data => console.log(data), error => console.log(error));
     
    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['viewPayees']);
  }
}

