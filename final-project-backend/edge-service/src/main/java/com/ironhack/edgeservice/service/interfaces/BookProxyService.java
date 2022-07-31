package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookProxyService {
    Book postBook (Book book);

    void deleteBook (long id);

    Optional<Book> getBook (long id);

    List<Book> findAvailableBooks();
}
