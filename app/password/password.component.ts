import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-password',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent implements OnInit {

  msg: any;
  user:any;
  email ="";
  password ="";
  pwd:any;
  newpassword ="";
  userid:number;
  constructor(private service: DataService,
    private router: Router) 
    { }

  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    this.email = this.user.email;
    this.userid = this.user.u_id;
  }

  changePwd()
  {

    if(this.user.password == this.password)
    {
      console.log(this.email);
      console.log(this.password);
      console.log(this.newpassword);
      console.log(this.userid);
      this.user.password = this.newpassword;
      this.service.changePwd(this.userid,this.user).subscribe((res)=>{
        console.log(res);
            if(res.first_name == "Validation Error")
            {
              const res = confirm("Invalid Password. Please Try Again");
              if(res==true)
              this.router.navigate(['/password'])
            }
            else
            { 
              const res = confirm("Password Changed Succesfully Successfully");
              if(res==true)
              this.router.navigate(['/loggedUser'])
            }
        this.router.navigate(['/loggedUser']);
      })
    }
    else{
      const res = confirm("Invalid Password. Please Try Again");
        if(res==true)
        this.router.navigate(['/password']);
    }
  }

 

  Cancel()
  {
      this.router.navigate(['/loggedUser'])
  }
}
