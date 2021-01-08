import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users:any;

  constructor(public service:DataService, private router:Router) 
  { 
    this.getUserData();
  }

  getUserData()
  {
    this.service.getUserData().subscribe((res)=>{
      console.log(res);
      this.users=res;
    },(error)=>{
      console.log(error)
    })
  }

  delete(id)
  {
    const res = confirm("Are you sure want to delete book with ID : "+ id);
    if(res==true){
      this.service.deleteUser(id).subscribe((res)=>{
        this.getUserData();
      })
    }
  }

  back()
  {
    this.router.navigate(['/admin']);
  }

  
  ngOnInit() {
  }

}
