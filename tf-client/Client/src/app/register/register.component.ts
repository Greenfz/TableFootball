import { Component, OnInit } from '@angular/core';
import { HttpService } from '../service/http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  _pathToRegister: string = '/register'
  costam = {}
  _responseMessage: string


  constructor(private _httpService: HttpService,
              private _router: Router) { }


  register(){
    console.log(this.costam);
    this._httpService.postToEndpoint(this.costam, this._pathToRegister )
    .subscribe(
      res => (console.log(res), this._router.navigate(['/login'])),
      err => (console.log(err),
              this._responseMessage = err.error.message)
              )
  }
}
