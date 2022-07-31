package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.BookProxyClient;
import com.ironhack.edgeservice.model.Book;
import com.ironhack.edgeservice.service.interfaces.BookProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class BookProxyServiceImpl implements BookProxyService {
    @Autowired
    private BookProxyClient bookProxyClient;


    public Book postBook(@RequestBody Book book) {
        return bookProxyClient.postBook(book);
    }


    public void deleteBook(long id) {
        bookProxyClient.deleteBook(id);
    }


    public Optional<Book> getBook(long id) {
        return bookProxyClient.getBook(id);
    }
}
