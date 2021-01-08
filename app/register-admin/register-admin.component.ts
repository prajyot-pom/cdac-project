import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.css']
})
export class RegisterAdminComponent implements OnInit {

  admin:{"role":"ADMIN"};

  constructor(private router: Router, private service:DataService) { }


  GoBackHome()
  {
      this.router.navigate(['/admin'])
  }

  AddAdmin(myForm)
  {
    console.log(myForm.form.value);
    this.admin=myForm.form.value;
    this.admin.role="ADMIN";
    console.log(this.admin);
    this.service.AddUserData(this.admin).subscribe((res:any)=>{
      console.log(res);
      if(res.first_name == "Validation Error")
      {
        const msg = confirm("Invalid Insertion. Please Try Again");
         if(msg==true)
         this.router.navigate(['/registerAdmin'])
      }
      else
      {
        
        const msg2 = confirm("Admin Added Successfully");
        if(msg2==true)
        this.router.navigate(['/user'])
      }
    })
  }

  ngOnInit() {
  }


}


