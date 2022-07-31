import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit {

  user:User;
  constructor(
    private router: Router,
  ) { 
    this.user = new User (0,"","",0);
  }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem("user") as string);
  }

  back(){
    this.router.navigate(['/searcher']);
  }

}
