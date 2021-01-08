import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  user:any=JSON.parse(sessionStorage.getItem("user"));
  cart:any;
  userid:number;
  constructor(private router:Router, private service:DataService) {
    
    this.userid=this.user.u_id;
    this.getCartData(this.userid);
   }

   getCartData(id)
   {
    this.service.getCartData(id).subscribe((res)=>{
      console.log(res);
      this.cart=res;
    },(error)=>{
      console.log(error)
    })
   }

   back()
   {
     this.router.navigate(['/loggedUser']);
   }

  ngOnInit() {
  }

  delete(id)
  {
    const res = confirm("Are you sure want to drop this item from your cart?");
    if(res==true){
      this.service.deleteItem(id,this.userid).subscribe((res:any)=>{
        console.log(res);
        if(res.book_name == "Validation User")
        {
            const msg = confirm("Something Wrong Please Try Again");
            if(msg==true)
            this.router.navigate(['/cart']);
        }
        else
        {
          const msg = confirm("Item Deleted Successfully");
          if(msg == true)
          this.router.navigate(['/loggedUser']);
        }
      })
    }
  }

}
