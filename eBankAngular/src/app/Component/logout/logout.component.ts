import { Component, OnInit } from '@angular/core';
import { StoreService } from 'src/app/Services/store.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private store:StoreService) { 

    this.store.loginStatus=0;
    this.store.setLoginStatus(0,0);
  }

  ngOnInit(): void {

    
  }
  }


