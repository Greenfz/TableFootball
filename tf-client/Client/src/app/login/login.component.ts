import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../service/authorization.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  registeredEmail : string = '';
  userDetails = {}

  constructor(private _authService: AuthorizationService) { }

  ngOnInit() {
  }

  loginMethod(){
    console.log(this.userDetails);
    this._authService.loginUser(this.userDetails)
    .subscribe(
      res => console.log(res),
      err => console.log(localStorage),
    )
  }

}
