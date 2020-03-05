import { Component, OnInit } from '@angular/core';
import { HttpService } from '../service/http.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
 
  _pathToLogin: string = '/login'
  _registeredEmail : string = '';   // ??????
  userDetails = {}
  
  constructor(
    private _httpService: HttpService
    ) { }


  loginMethod(){
    console.log(this.userDetails);

    this._httpService.postToEndpoint(this.userDetails, this._pathToLogin)
    .subscribe(
      res => console.log(res),
      err => console.log(localStorage),
    )
  }

}
