import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logged-user',
  templateUrl: './logged-user.component.html',
  styleUrls: ['./logged-user.component.css']
})
export class LoggedUserComponent implements OnInit {

  books:any
  fname: any;
  user:any;
  title:"";
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

  search()
  {
    this.service.Search(this.title).subscribe((res)=>
    {
      console.log(res);
      sessionStorage.setItem("searchedBook",JSON.stringify(res))
      this.router.navigate(['/searchBook/']);    
    })
  }

  // View()
  // {
  //   this.router.navigate(['/bookDetail'])
  // }

  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    this.fname = this.user.first_name;
  }

}
