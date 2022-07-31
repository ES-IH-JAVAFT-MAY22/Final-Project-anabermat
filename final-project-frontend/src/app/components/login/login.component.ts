import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  usernameInput: FormControl;
  passwordInput: FormControl;


  constructor(
    private router: Router,
    private userService: UserService
  ) {
    this.usernameInput = new FormControl('', [Validators.required]);
    this.passwordInput = new FormControl('', [Validators.required]);
    this.loginForm = new FormGroup({
      username: this.usernameInput,
      password: this.passwordInput,
   });
  }

  ngOnInit(): void {
  }

  login(){

      const newUser: User = this.loginForm.value;
      newUser.id = 1;
      newUser.balance = 0;
      this.userService.addUser(newUser).subscribe();

      localStorage.setItem("user",JSON.stringify(newUser));

      this.router.navigate(['/searcher']);
    }
  }
  

