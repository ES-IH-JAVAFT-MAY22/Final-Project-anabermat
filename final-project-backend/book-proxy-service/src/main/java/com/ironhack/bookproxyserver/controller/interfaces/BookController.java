package com.ironhack.bookproxyserver.controller.interfaces;

import com.ironhack.bookproxyserver.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookController {

    Book postBook (Book book);

    void deleteBook (long id);

    Book getBook (long id);

    List<Book> findAvailableBooks();
}
