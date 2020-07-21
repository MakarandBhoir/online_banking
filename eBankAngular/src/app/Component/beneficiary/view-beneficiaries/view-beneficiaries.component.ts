import { Component, OnInit } from '@angular/core';
import { Beneficiary } from 'src/app/Model/beneficiary';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/Services/user.service ';
import { Router } from '@angular/router';
import { StoreService } from 'src/app/Services/store.service';

@Component({
  selector: 'app-view-beneficiaries',
  templateUrl: './view-beneficiaries.component.html',
  styleUrls: ['./view-beneficiaries.component.css']
})
export class ViewBeneficiariesComponent implements OnInit {

  payees: Observable<Beneficiary[]>;
  payee:Beneficiary;
  uid:String;
  
    constructor(private userService: UserService, private router:Router,private store: StoreService)
    { 
     
    }
  
   
    ngOnInit() {
     
      this.reloadData();
    }
  
    
    reloadData() {
     
     this.uid=localStorage.getItem("user_IdL");  
     this.payees = this.userService.getallPayeesByUID(this.uid);
    }
  
    deletePayee(bid: number) {
    this.userService.deletePayee(bid)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

   
    payeeDetails(bid: number){
      this.router.navigate(['payeedetails', bid]);
    }

    
    updatePayee(id: number){
      this.router.navigate(['update', id]);
    }
    addPayee(){
      this.router.navigate(['addPayee']);
    }


  
  }