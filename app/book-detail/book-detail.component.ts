import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

  book:any
  title:any;
  author:any;
  publication:any;
  price:any;
  count:any;
  type:any;
  isbn:any;
  user:any = JSON.parse(sessionStorage.getItem('user'));
  qty:number;

  constructor(private route:ActivatedRoute,
              private service: DataService,
              private router: Router) { }


  Order()
  {
    this.service.AddToCart(this.book.b_id, this.qty, this.user.u_id,this.book.title,this.book.price).subscribe((result:any)=>{
      console.log("milal");
      console.log(result);
      if(result.u_id == this.user.u_id)
      {
        const msg = confirm("Added to Cart");
        if(msg==true)
          this.router.navigate(['/loggedUser']);
      }
    });
  }

  Previous()
  {
    this.router.navigate(['/loggedUser'])
  }
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

        this.title=this.book.title;
        this.author=this.book.author;
        this.type=this.book.type;
        this.isbn=this.book.isbn;
        this.publication=this.book.publication;
        this.price=this.book.price;
        this.count=this.book.count;
      })
    }); 
  }

}
