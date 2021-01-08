import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {

  user:any=JSON.parse(sessionStorage.getItem("user"));
  address:any;
  addId:number;
  street:"";
  city:"";
  state:"";
  country:"";
  houseNo:number;
  pincode:number;


  constructor(public service:DataService, public router: Router) 
  {
      this.getAddressData(this.user.u_id);
  }

  getAddressData(id)
  {
      this.service.getAddressData(id).subscribe((res)=>{
        console.log("we got address list as below")
        console.log(res);
        this.address=res;
        this.addId=this.address.a_id;
        this.houseNo=this.address.house_no;
        this.street=this.address.street;
        this.state=this.address.state;
        this.city=this.address.city;
        this.pincode=this.address.pincode;
        this.country=this.address.country;
      })
  }

  delete(id)
  {
    const res = confirm("Are you sure want to delete book with ID : "+ id);
    if(res==true){
      this.service.deleteAddress(id,this.user.u_id).subscribe((res:any)=>{
        console.log(res);
        if(res.u_id == this.user.u_id)
        {
          const res = confirm("Address Removed Successfully");
          if(res==true)
          this.router.navigate(['/address'])
        }
      })
    }
  }

  back()
  {
    this.router.navigate(['/loggedUser']);
  }

  Edit()
  {
    this.router.navigate(['/editAddress/'+this.address.a_id])
  }
  ngOnInit() {
  }

}
