import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  books:any
  constructor(public service:DataService,private router: Router) 
  {
    this.getBookData();
  }


  getBookData()
  {
    this.service.getBookData().subscribe((res)=>{
      console.log(res);
      this.books=res;
    },(error)=>{
      console.log(error)
    })
  }

  ngOnInit() {
  }

}
