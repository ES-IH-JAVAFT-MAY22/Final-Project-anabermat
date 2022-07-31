import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/models/book.model';
import { User } from 'src/app/models/user.model';
import { BookService } from 'src/app/services/book.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-retrieve-books',
  templateUrl: './retrieve-books.component.html',
  styleUrls: ['./retrieve-books.component.css']
})
export class RetrieveBooksComponent implements OnInit {

  user: User;
  books: Book[];
  constructor(
    private router: Router,
    private userService: UserService,
    private bookService: BookService
  ) { 
    this.user = new User(0,"","",0);
    this.books = [new Book(0,"Alicia en el País de las Maravillas",120,"Lewis Carroll"), 
    new Book(1,"Harry Potter",560,"JK Rowling"),
    new Book(2,"El Señor de los Anillos",458,"J.R.R. Tolkien"),
    new Book(3,"El principito",52,"Antoine de Saint-Exupéry"),
    new Book(4,"Las mil y una noches",658,"Anónimo"),
    new Book(5,"Don Quijote de la Mancha",256,"Miguel de Cervantes")];
  }

  ngOnInit(): void {
    this.bookService.getAvailableBooks().subscribe();
  }

  retrieveBook(){
    const book: Book = this.books[3];

    this.user = JSON.parse(localStorage.getItem("user") as string);
    console.log(this.user);

    if(book.numberOfPages<100){
      this.user.balance = this.user.balance - 10;
    }else if(book.numberOfPages>100 && book.numberOfPages < 250){
      this.user.balance = this.user.balance - 20;
    } else if(book.numberOfPages > 250 && book.numberOfPages < 500){
      this.user.balance = this.user.balance - 50;
    }else{
      this.user.balance = this.user.balance - 100;
    }

    console.log(this.user.balance);

    localStorage.setItem("user",JSON.stringify(this.user));

    this.router.navigate(['/banner']);
  }

  back(){
    this.router.navigate(['/searcher']);
  }
}
