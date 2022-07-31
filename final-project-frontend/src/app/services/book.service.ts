import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../models/book.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private readonly API_URL = 'http://localhost:8081';

  constructor(
    private http: HttpClient
  ) { }

  addBook(book: Book): any {
    console.log(book);
    return this.http.post<any>(`http://localhost:8081/books`, book);
  }

  deleteBook(id:number): any {
    console.log(id);
    return this.http.delete<any>(`http://localhost:8081/books/${id}`);
  }

  getAvailableBooks():any {
    return this.http.get<any>(`http://localhost:8081/books`);
  }
  

}
