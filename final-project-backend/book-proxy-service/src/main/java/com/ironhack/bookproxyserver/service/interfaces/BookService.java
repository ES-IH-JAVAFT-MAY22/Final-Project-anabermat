package com.ironhack.bookproxyserver.service.interfaces;

import com.ironhack.bookproxyserver.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book postBook (Book book);

    void deleteBook (long id);

    Book getBook (long id);

    List<Book> findAvailableBooks();
}
