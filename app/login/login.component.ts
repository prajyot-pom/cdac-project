import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  message:any;
  constructor(private service: AuthService, private router: Router) 
  {

  }

  ngOnInit() 
  {
  }

  SignIn(loginForm)
  {
    let loginCredentials = loginForm.form.value;
    console.log(loginCredentials);

    // this.service.CheckCredentialsWithDB(loginCredentials);

   
     let isUserValid= this.service.CheckCredentialsWithDB(loginCredentials);
    console.log(isUserValid);
  
    if(!isUserValid)
    {
      console.log("User Is Invalid");
      this.message = "User Name / Password is Invalid!";
      this.router.navigate(['/login']); 
    }
  }

  Register()
  {
    this.router.navigate(['/register']);
  }

  Cancel()
  {
    this.router.navigate(['/home']);
  }
}








