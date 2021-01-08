import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-book',
  templateUrl: './search-book.component.html',
  styleUrls: ['./search-book.component.css']
})
export class SearchBookComponent implements OnInit {

  books:any;
  fname:any;
  user:any;
  SearchedBook:any;
  title = "";
  constructor(public service:DataService,private router :Router) { 

    this.getData();
    this.SearchedBook = JSON.parse(sessionStorage.getItem("searchedBook"));
    console.log("Inside Searched book");
    console.log(this.SearchedBook);

   }


  getData(){
    var abc;
    this.service.getBookData().subscribe((res)=>{
      console.log("Inside GEtdata");
      
      this.books =res;
      console.log("Inside component--->"+this.books)
    
    },(error)=>{
      console.log(error)
    })
  }

  View()
  {
   this.router.navigate(['/bookDetail']) 
  }
  back()
  {
    this.router.navigate(['/loggedUser'])
  }


  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    this.fname = this.user.first_name;
    }


}
