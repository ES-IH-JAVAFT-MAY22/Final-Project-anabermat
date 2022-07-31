package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.BalanceProxyClient;
import com.ironhack.edgeservice.model.Book;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.service.interfaces.BalanceProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin ("*")
public class BalanceProxyClientImpl implements BalanceProxyClient {

    @Autowired
    private BalanceProxyService balanceProxyService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) {
        return balanceProxyService.postUser(user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) {
        balanceProxyService.deleteUser(id);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable long id) {
        return balanceProxyService.getUser(id);
    }

    @PutMapping("/users/up/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateBalance(@PathVariable long id, @RequestBody Book book) {
        return balanceProxyService.updateBalance(id,book);
    }

    @GetMapping("/users/bookList/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBookList(@PathVariable long id) {
        return balanceProxyService.getBookList(id);
    }

    @PutMapping("/users/down/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User smallerBalance(long id, Book book) {
        return balanceProxyService.smallerBalance(id,book);
    }

    @PostMapping("/users/bookList/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Book> addToBookList(Book book, long id) {
        return balanceProxyService.addToBookList(book,id);
    }
}
