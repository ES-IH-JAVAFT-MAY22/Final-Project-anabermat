package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.model.Book;

import java.util.Optional;

public interface BookProxyController {
    Book postBook (Book book);

    void deleteBook (long id);

    Optional<Book> getBook (long id);

}
