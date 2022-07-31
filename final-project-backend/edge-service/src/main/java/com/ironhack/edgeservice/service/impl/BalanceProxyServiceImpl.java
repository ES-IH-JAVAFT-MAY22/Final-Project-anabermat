package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.BalanceProxyClient;
import com.ironhack.edgeservice.model.Book;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.service.interfaces.BalanceProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceProxyServiceImpl implements BalanceProxyService {

    @Autowired
    private BalanceProxyClient balanceProxyClient;

    public User postUser(User user) {
        return balanceProxyClient.postUser(user);
    }


    public void deleteUser(long id) {
        balanceProxyClient.deleteUser(id);
    }

    @Override
    public User getUser(long id) {
        return balanceProxyClient.getUser(id);
    }

    @Override
    public User updateBalance(long id, Book book) {
        return balanceProxyClient.updateBalance(id,book);
    }

    @Override
    public List<Book> getBookList(long id) {
        return balanceProxyClient.getBookList(id);
    }
}
