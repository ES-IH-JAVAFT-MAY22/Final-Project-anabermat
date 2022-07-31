import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from 'src/app/models/book.model';
import { User } from 'src/app/models/user.model';
import { BookService } from 'src/app/services/book.service';
import { UserService } from 'src/app/services/user.service';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.css']
})
export class SearcherComponent implements OnInit {

  registerForm: FormGroup;
  titleInput: FormControl;
  numberOfPagesInput: FormControl;
  writerInput: FormControl;
  user: User;

  constructor(
    private router: Router,
    private userService: UserService,
    private bookService: BookService
  ) { 
    this.titleInput = new FormControl('',[Validators.required]);
    this.numberOfPagesInput = new FormControl('',[Validators.required, Validators.min(10)]);
    this.writerInput = new FormControl('', [Validators.required]);

    this.user = new User(0,"","",0);
    

    this.registerForm = new FormGroup({
      title: this.titleInput,
      numberOfPages: this.numberOfPagesInput,
      writer: this.writerInput,
    }
    )
  }

  ngOnInit(): void {
  }

  onSubmit(){

    const book: Book = this.registerForm.value;
    this.user = JSON.parse(localStorage.getItem("user") as string);
    console.log(this.user);
    this.bookService.addBook(book).subscribe();
    this.userService.moreBalance(this.user.id,book).subscribe();

    if(book.numberOfPages<100){
      this.user.balance = this.user.balance + 10;
    }else if(book.numberOfPages>100 && book.numberOfPages < 250){
      this.user.balance = this.user.balance + 20;
    } else if(book.numberOfPages > 250 && book.numberOfPages < 500){
      this.user.balance = this.user.balance + 50;
    }else{
      this.user.balance = this.user.balance + 100;
    }

    console.log(this.user.balance);

    localStorage.setItem("user",JSON.stringify(this.user));
  }


  retrieveBooks(){
    this.router.navigate(['/retrieveBooks']);
  }


}
