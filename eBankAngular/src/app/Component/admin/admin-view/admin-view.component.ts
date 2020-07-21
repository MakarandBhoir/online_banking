import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import {AccountRequest} from 'src/app/Model/account-request';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
  selector: 'app-admin-view',
  templateUrl: './admin-view.component.html',
  styleUrls: ['./admin-view.component.css']
})
export class AdminViewComponent implements OnInit {

    accrequests: Observable<AccountRequest[]>;
    accountreq:AccountRequest;
    constructor(private adminService: AdminService, private router:Router)
    { }
  
   
    ngOnInit() {
      this.reloadData();
    }
  
    reloadData() {
     this.accrequests = this.adminService.getallAccounts();
    }
  
   
    accountDetails(id: number){
      this.router.navigate(['details', id]);
    }
  
  }