import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { UserModel } from "./model/UserModel";

@Injectable({
  providedIn: 'root'
})
export class AppService{

    apiUrl:string = "http://localhost:8082/users/";

    httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    constructor(
      private httpClient: HttpClient
    ) { }

    public enviar(user: UserModel): Observable<any> {
      return this.httpClient.post(this.apiUrl, user);
    }
}
