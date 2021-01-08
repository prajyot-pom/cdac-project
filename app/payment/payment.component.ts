import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  user:any=JSON.parse(sessionStorage.getItem("user"));
 
  userid:number;
  sum:any;
  constructor(private router:Router, private service:DataService) {
    
    this.userid=this.user.u_id;
    this.getPayment(this.userid);
   }

   getPayment(id)
   {
    this.service.getPaymentAmount(id).subscribe((res)=>{
      console.log(res);
      this.sum=res;
      
    },(error)=>{
      console.log(error)
    })
   }

   pay()
   {
     const msg= confirm("Order Placed SuccessFully!!!")
     if(msg == true)
     {
       //this.service.clearCart(this.user.u_id).subscribe((result)=>{
        // console.log(result);
         this.router.navigate(['/loggedUser']);
       //});
     }
     else
     {
       this.router.navigate(['/payment']);
     }

   }

  Cancel()
  {
    this.router.navigate(['/cart'])
  }
  ngOnInit() {
  }

}
