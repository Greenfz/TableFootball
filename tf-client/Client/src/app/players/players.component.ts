import { Component, OnInit} from '@angular/core';
import { HttpService } from '../service/http.service';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent {

  model: any = {};

  constructor(
    private _authService: HttpService
  ) {}


  func(): void {
    console.log(this.model)
  }
}
