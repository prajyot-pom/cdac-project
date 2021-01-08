import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

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

  back()
  {
    this.router.navigate(['/admin']);
  }

  addBook()
  {
    this.router.navigate(['/addBook'])
  }

  delete(id)
  {
    const res = confirm("Are you sure want to delete book with ID : "+ id);
    if(res==true){
      this.service.deleteBook(id).subscribe((res)=>{
        this.getBookData();
      })
    }
  }

  ngOnInit() {
  }

}
