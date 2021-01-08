import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-book-admin',
  templateUrl: './search-book-admin.component.html',
  styleUrls: ['./search-book-admin.component.css']
})
export class SearchBookAdminComponent implements OnInit {

  books:any;
  title: "";
  SearchedBook: any;
  constructor(public service:DataService,private router: Router) {
    this.getBookData();
    this.SearchedBook = JSON.parse(sessionStorage.getItem("searchedBook"));
    console.log("Inside Searched book");
    console.log(this.SearchedBook);
   }

 
getBookData(){

  this.service.getBookData().subscribe((res)=>{
    console.log(res);
    this.books=res;
  },(error)=>{
    console.log(error)
  })
} 
back()
{
  this.router.navigate(['/admin'])
}

delete(no){
    const result = confirm("Are you sure want to delete emp with ID : "+no);
    if(result==true){
      this.service.deleteBook(no).subscribe((res)=>{
        this.getBookData();
      })
    }
    
 }
 
 

  ngOnInit() {
  }
 

}
