import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book:any;
  message = "";
  constructor(private router : Router, private service:DataService) { }


  Cancel()
  {
      this.router.navigate(['/admin']);
  }

  AddBook(formdata){
    console.log(formdata.form.value);
    this.book=formdata.form.value;
    
    console.log(this.book);
    this.service.AddData(this.book).subscribe((res:any)=>{
      console.log(res);
      if(res.title == "Validation Error")
      {
        const res = confirm("Invalid Insertion. Please Try Again");
        if(res==true)
        this.router.navigate(['/addBook'])
      }
      else
      {
        
        const res = confirm("Book Added Successfully");
        if(res==true)
        this.router.navigate(['/book'])
      }
      //this.msg="Record added succesfully";
      //this.router.navigate(['/book']);
    })
    //alert("In Add");
  }
  ngOnInit() {
  }

}
