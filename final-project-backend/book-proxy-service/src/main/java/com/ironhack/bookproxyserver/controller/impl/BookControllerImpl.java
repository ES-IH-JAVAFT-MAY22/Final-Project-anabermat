package com.ironhack.bookproxyserver.controller.impl;

import com.ironhack.bookproxyserver.controller.interfaces.BookController;
import com.ironhack.bookproxyserver.model.Book;
import com.ironhack.bookproxyserver.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin ("*")
public class BookControllerImpl implements BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book) {
        return bookService.postBook(book);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAvailableBooks() {
        return bookService.findAvailableBooks();
    }


}
