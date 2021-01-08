import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-add-address',
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.css']
})
export class AddAddressComponent implements OnInit {

  public city = [{name:"kolhapur"},{name:"Pune"},{name:"Satara"},{name:"London"},{name:"Paris"},{name:"New York"},
                 {name:"Rome"},{name:"Singapore"},{name:"Hiroshima"},{name:"Nagasaki"},{name:"Bijing"},{name:"Karachi"},
                 {name:"Berlin"},{name:"Sydney"},{name:"Kolambo"},{name:"Manchester"},{name:"Chicago"},{name:"Dallas"}];

  public state = [{name:"Maharashtra"},{name:"AP"},{name:"MP"},{name:"UP"},{name:"Panjab"},{name:"Keral"},
                  {name:"Asam"},{name:"Telangana"},{name:"Hariyana"},{name:"TN"},{name:"Gujarat"},{name:"Rajasthan"},
                  {name:"Jammu"},{name:"Kashmir"}];

  public country = [{name:"India"},{name:"Pak"},{name:"Aus"},{name:"China"},{name:"UK"},{name:"USA"},
                  {name:"UAE"},{name:"Shrilanka"},{name:"Spain"},{name:"Nepal"},{name:"Bhutan"},{name:"France"},
                  {name:"Germany"},{name:"Dubai"}];

  user:any=JSON.parse(localStorage.getItem("logger"));
  
  address:any;
  constructor(private router:Router, private service:DataService) { }

  ngOnInit() {
    console.log(this.user.u_id);
  }

  AddAddress(myForm)
  {
    console.log(this.user.u_id);
    this.address=myForm.form.value;
    console.log(this.address);
    this.service.AddAddress(this.address,this.user.u_id).subscribe((res:any)=>{
      console.log(res);
      if(res.u_id == this.user.u_id)
      {
        const res = confirm("Address Added Successfully! Now Login and Enjoy Shopping");
        if(res==true)
        this.router.navigate(['/login'])
      }
    })
  }

  // Cancel()
  // {
  //     this.router.navigate(['/register']);
  // }
}
