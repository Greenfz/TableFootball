import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../service/authorization.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  costam = {}
  responseMessage: string


  constructor(private _authService: AuthorizationService,
              private _router: Router) { }

  ngOnInit() {
  }

  register(){
    console.log(this.costam);
    this._authService.registerUser(this.costam)
    .subscribe(
      res => (console.log(res), this._router.navigate(['/login'])),
      err => (console.log(err),
              this.responseMessage = err.error.message)
              )
  }
}
