import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import { CustomValidators } from 'src/app/utils/custom.validations';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  registerForm: FormGroup;
  usernameInput: FormControl;
  passwordInput: FormControl;
  passwordConfirmationInput: FormControl;

  constructor(
    private router: Router,
    private userService: UserService
  ) {
    this.usernameInput = new FormControl('', [Validators.required]);
    this.passwordInput = new FormControl('', [Validators.required]);
    this.passwordConfirmationInput = new FormControl('', [Validators.required]);
    this.registerForm = new FormGroup({
      username: this.usernameInput,
      password: this.passwordInput,
      passwordConfirmation: this.passwordConfirmationInput
    }, [CustomValidators.passwordMatch]);
  }


  ngOnInit(): void {
  }

  register() {

    const newUser: User = this.registerForm.value;
      this.userService.addUser(newUser).subscribe();
      newUser.id = 1;
      newUser.balance = 0;

      localStorage.setItem("user",JSON.stringify(newUser));

      this.router.navigate(['/searcher']);
  }

}
