import { Component } from '@angular/core';
import { User } from './models/user.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'finalProject';
  user: User;

  constructor() {
    this.user = new User(1,"","",0);
    localStorage.setItem("user",JSON.stringify(this.user));
   }
}


