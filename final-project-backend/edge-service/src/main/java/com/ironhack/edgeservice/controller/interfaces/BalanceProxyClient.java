package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.model.Book;
import com.ironhack.edgeservice.model.User;

import java.util.List;

public interface BalanceProxyClient {
    User postUser(User user);
    void deleteUser(long id);
    User getUser(long id);
    User updateBalance(long id, Book book);
    List<Book> getBookList(long id);
    User smallerBalance(long id, Book book);
    List<Book> addToBookList(Book book, long id);
}
