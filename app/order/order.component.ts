import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor(private router:Router) { }


  Back()
  {
    this.router.navigate(['/bookDetail'])
  }


  Payment()
  {
    this.router.navigate(['/payment'])
  }
  ngOnInit() {
  }

}
