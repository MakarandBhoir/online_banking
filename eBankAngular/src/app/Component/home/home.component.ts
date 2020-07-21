import { Component, OnInit } from '@angular/core';
import { StoreService } from 'src/app/Services/store.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  constructor(private store:StoreService) { }

  ngOnInit(): void {

}

}
