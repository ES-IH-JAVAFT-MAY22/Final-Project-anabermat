package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.Book;
import com.ironhack.edgeservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("balance-proxy-service")
public interface BalanceProxyClient {
    @PostMapping("/users")
    User postUser(@RequestBody User user);

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable long id);

    @GetMapping("/users/{id}")
    User getUser(@PathVariable long id);

    @PutMapping("/users/up/{id}")
    @ResponseStatus(HttpStatus.OK)
    User updateBalance(@PathVariable long id, @RequestBody Book book);

    @PutMapping("/users/down/{id}")
    User smallerBalance(@PathVariable long id, @RequestBody Book book);

    @GetMapping("/users/bookList/{id}")
    List<Book> getBookList(@PathVariable long id);

    @PostMapping("/users/bookList/{id}")
    List<Book> addToBookList(@RequestBody Book book, @PathVariable long id);
}
