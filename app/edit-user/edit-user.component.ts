import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  user:any=JSON.parse(sessionStorage.getItem("user"));
  constructor(private router:Router,
              private service: DataService) { }

  ngOnInit() {
  //  let user = JSON.parse(sessionStorage.getItem("user"));
    console.log(this.user);
    let id = this.user.u_id;
    console.log("we got id of current user + "+id);
    let observableResult = this.service.getUserDataById(id);
      console.log(observableResult);
      observableResult.subscribe((result)=>{
        console.log(result);
        this.user=result;
        console.log(this.user);
      })
  }

  OnEditUser()
  {
    console.log("inside edit component.ts")
    console.log(this.user);
    console.log("-----------------------------------------------------------------")
    this.service.updateUser(this.user).subscribe((result)=>{
      console.log("after updating... ");
      console.log(result);
      console.log("-----------------------------------------------------------------")
      const msg = confirm("Changes Saved Successfully")
      if(msg==true && result.role == "USER")
      {
        this.router.navigate(['/loggedUser']);
      }
      else if(msg==true && result.role == "ADMIN")
      {
        this.router.navigate(['/user']);
      }
      else
        this.router.navigate(['/editUser']);
    })
  }

  Cancel()
  {
    if(this.user.role == "ADMIN")
    {
      this.router.navigate(['/admin'])
    }
    else
    this.router.navigate(['/loggedUser']);
  }
}
