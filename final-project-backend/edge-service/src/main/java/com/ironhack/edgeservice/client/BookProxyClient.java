package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@FeignClient("book-proxy-service")
public interface BookProxyClient {

    @PostMapping("/books")
    public Book postBook(@RequestBody Book book);

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable long id);

    @GetMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable long id);

    @GetMapping("/books")
    public List<Book> findAvailableBooks();
}
