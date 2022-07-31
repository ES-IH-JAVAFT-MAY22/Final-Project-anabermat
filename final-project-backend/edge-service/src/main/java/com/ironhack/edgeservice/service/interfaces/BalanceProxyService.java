package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.model.Book;
import com.ironhack.edgeservice.model.User;

import java.util.List;

public interface BalanceProxyService {
    User postUser(User user);
    void deleteUser(long id);
    User getUser(long id);
    User updateBalance(long id, Book book);
    List<Book> getBookList(long id);
}
