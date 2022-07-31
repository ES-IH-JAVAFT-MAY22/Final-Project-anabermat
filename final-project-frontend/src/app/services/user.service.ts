import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book.model';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private http: HttpClient
  ) { }

  addUser(user: User): Observable<User> {
    console.log(user);
    return this.http.post<any>(`http://localhost:8082/users`, user);
  }

  getUser(id:number): any{
    console.log(id);
    return this.http.get<any>(`http://localhost:8082/users/${id}`);
  }

  addToBookList(book:Book,id:number): any {
    console.log(book,id);
    return this.http.post<any>(`http://localhost:8082/users/bookList/${id}`, book);
  }

  getBookList(id:number): any{
    console.log(id);
    return this.http.get<any>(`http://localhost:8082/users/bookList/${id}`);
  }

  moreBalance(id:number, book:Book): any{
    console.log(id,book);
    return this.http.put<any>(`http://localhost:8082/users/up/${id}`,book);

  }

  lessBalance(id:number, book:Book): any{
    console.log(id,book);
    this.http.put<any>(`http://localhost:8082/users/down/${id}`,book);
  }
}
