package com.ironhack.saldoproxyserver.service.interfaces;

import com.ironhack.saldoproxyserver.model.Book;
import com.ironhack.saldoproxyserver.model.User;

import java.util.List;

public interface UserService {
    User postUser(User user);
    void deleteUser(long id);
    User getUser(long id);
    User updateBalance(long id, Book book);
    User smallerBalance(long id, Book book);
    List<Book> getBookList(long id);

    List<Book> addToBookList(Book book, long id);
}
