import { UserService } from '../user.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import{User} from '../user';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  user: User = new User();
  submitted = false;


  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit() { 
  }

  newEmployee(): void {
    this.submitted = false;
  }

  // save() {
  //   this.userService
  //   .createUser(this.user).subscribe(data => {
  //     console.log(data)
  //     this.user = new User();
  //     this.gotoList();
  //   }, 
  //   error => console.log(error));
  // }

  onSubmit() {
    this.submitted = true;
    this.userService.login(this.user).subscribe(data=>{
      localStorage.setItem('token', data.token);
      if(data.role=="admin"){
        this.router.navigate(["/admin"]);
        return;
      }
      this.router.navigate(["/userpage"]);
    },error=>{
      console.log(error); 
    });  
  }

  gotoList() {
    this.router.navigate(['/users']);
  }


}
