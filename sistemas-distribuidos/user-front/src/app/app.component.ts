import { Component } from '@angular/core';
import { AppService } from './app.service';
import { UserModel } from './model/UserModel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'front';
  user: UserModel = new UserModel();


  constructor(
    private appService: AppService
  ){

  }

  enviar(){
    this.appService.enviar(this.user).subscribe();
  }
}
