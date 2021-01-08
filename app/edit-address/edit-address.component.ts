import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-edit-address',
  templateUrl: './edit-address.component.html',
  styleUrls: ['./edit-address.component.css']
})
export class EditAddressComponent implements OnInit {


  public city = [{name:"kolhapur"},{name:"Pune"},{name:"Satara"},{name:"London"},{name:"Paris"},{name:"New York"},
                 {name:"Rome"},{name:"Singapore"},{name:"Hiroshima"},{name:"Nagasaki"},{name:"Bijing"},{name:"Karachi"},
                 {name:"Berlin"},{name:"Sydney"},{name:"Kolambo"},{name:"Manchester"},{name:"Chicago"},{name:"Dallas"}];

public state = [{name:"Maharashtra"},{name:"AP"},{name:"MP"},{name:"UP"},{name:"Panjab"},{name:"Keral"},
                {name:"Asam"},{name:"Telangana"},{name:"Hariyana"},{name:"TN"},{name:"Gujarat"},{name:"Rajasthan"},
                {name:"Jammu"},{name:"Kashmir"}];

public country = [{name:"India"},{name:"Pak"},{name:"Aus"},{name:"China"},{name:"UK"},{name:"USA"},
                  {name:"UAE"},{name:"Shrilanka"},{name:"Spain"},{name:"Nepal"},{name:"Bhutan"},{name:"France"},
                  {name:"Germany"},{name:"Dubai"}];

user:any=JSON.parse(sessionStorage.getItem("user"));
address:any;

  constructor(private route:ActivatedRoute, private router:Router, private service: DataService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let id= result.get("a_id");
      console.log(id);

      let observableResult = this.service.getAddressDataById(id);
      console.log(observableResult);
      observableResult.subscribe((result)=>{
        console.log(result);
        this.address=result;
        console.log(this.address);
      })
    }); 
  }

  EditAddress()
  {
    this.service.updateAddress(this.address).subscribe((result)=>{
      console.log("after updating... ");
      console.log(result);
      this.router.navigate(['/address']);
    })
  }

  Cancel()
  {
    this.router.navigate(['/address']);
  }
}
