package com.ironhack.saldoproxyserver.controller.impl;

import com.ironhack.saldoproxyserver.controller.interfaces.UserController;
import com.ironhack.saldoproxyserver.model.Book;
import com.ironhack.saldoproxyserver.model.User;
import com.ironhack.saldoproxyserver.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin ("*")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) {
        return userService.postUser(user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PutMapping("/users/up/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateBalance(@PathVariable long id, @RequestBody Book book) {
        return userService.updateBalance(id,book);
    }

    @PutMapping("/users/down/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User smallerBalance(long id, Book book) {
        return userService.smallerBalance(id,book);
    }

    @GetMapping("/users/bookList/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBookList(@PathVariable long id) {
        return userService.getBookList(id);
    }

    @PostMapping("/users/bookList/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Book> addToBookList(@RequestBody Book book, @PathVariable long id) {
        return userService.addToBookList(book,id);
    }
}
