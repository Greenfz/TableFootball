import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private _appUrl = 'http://localhost:8080';
  
  constructor(private http: HttpClient) { }

  postToEndpoint(model: any, path: string){
    console.log(this.prepareUrl(path))
    return this.http.post<any>(this.prepareUrl(path), model)
  }

  getFromEndpoint(path:string){
    return this.http.get(this.prepareUrl(path))
  }



  private prepareUrl(path: string){
    return this._appUrl+path;
  }
}
