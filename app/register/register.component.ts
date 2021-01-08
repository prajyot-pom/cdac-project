import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  
  user:{"role":"USER"};

  constructor(private router: Router, private service:DataService) { }


  GoBackHome()
  {
      this.router.navigate(['/home'])
  }

  AddUser(myForm)
  {
    console.log(myForm.form.value);
    this.user=myForm.form.value;
    this.user.role="USER"
    console.log(this.user);
    this.service.AddUserData(this.user).subscribe((res:any)=>{
      console.log(res);
      localStorage.setItem("logger",JSON.stringify(res));
      if(res.first_name == "Validation Error")
      {
        const msg = confirm("Invalid Insertion. Please Try Again");
         if(msg==true)
         this.router.navigate(['/register'])
      }
      else
      {
        
        const msg2 = confirm("You have Registered Successfully. One More Step to Go...Add Your Address");
        if(msg2==true)
        this.router.navigate(['/addAddress'])
      }
    })
  }

  ngOnInit() {
  }


}
