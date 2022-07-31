package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.client.BookProxyClient;
import com.ironhack.edgeservice.controller.interfaces.BookProxyController;
import com.ironhack.edgeservice.model.Book;
import com.ironhack.edgeservice.service.interfaces.BookProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin ("*")
public class BookProxyControllerImpl implements BookProxyController {

    @Autowired
    private BookProxyService bookProxyService;

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book) {
        return bookProxyService.postBook(book);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(long id) {
        bookProxyService.deleteBook(id);
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Book> getBook(long id) {
        return bookProxyService.getBook(id);
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAvailableBooks() {
        return bookProxyService.findAvailableBooks();
    }
}
