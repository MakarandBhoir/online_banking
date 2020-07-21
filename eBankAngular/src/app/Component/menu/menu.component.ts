import { Component, OnInit } from '@angular/core';

import { StoreService } from 'src/app/Services/store.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
loginStatus:string;
userType:string;
 

  constructor(public store: StoreService,private route: Router) { }

  ngOnInit(): void {
  

    this.loginStatus=localStorage.getItem("loginStatusL");

    this.userType=localStorage.getItem("userTypeL");
    if(this.loginStatus==undefined || this.userType==undefined)
    { this.loginStatus='0'; 
    this.userType='0';
   
  }

}
  onLogout() {
    localStorage.removeItem('');
    localStorage.clear();
    this.loginStatus="0";
    this.userType="0";
        this.route.navigate(['login']);
   
  }
}
