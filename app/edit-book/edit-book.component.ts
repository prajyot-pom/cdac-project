import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {

  book : any ;//={"b_id":"111","title":"","author":"","publication":"","type":"","isbn":"","price":"","image":"","count":""};

  // emp= {"No": "123", "Name": "", "Age":""};
  constructor(private route:ActivatedRoute,
              private service: DataService,
              private router: Router) { }

  ngOnInit() 
  {
      this.route.paramMap.subscribe((result)=>{
      let id= result.get("b_id");
      console.log(id);

      let observableResult = this.service.getBookDataById(id);
      console.log(observableResult);
      observableResult.subscribe((result)=>{
        console.log(result);
        this.book=result;
        console.log(this.book);
      })
    }); 
  }

  OnEdit()
  {
    console.log(this.book);

    this.service.updateBook(this.book).subscribe((result)=>{
      console.log("after updating... ");
      console.log(result);
      this.router.navigate(['/book']);
    })
  }

  
  Cancel()
  {
    this.router.navigate(['/book']);
  }

}
