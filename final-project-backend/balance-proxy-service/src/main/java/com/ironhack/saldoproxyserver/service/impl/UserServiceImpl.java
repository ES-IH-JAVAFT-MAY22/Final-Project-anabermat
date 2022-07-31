package com.ironhack.saldoproxyserver.service.impl;

import com.ironhack.saldoproxyserver.model.Book;
import com.ironhack.saldoproxyserver.model.User;
import com.ironhack.saldoproxyserver.repository.UserRepository;

import com.ironhack.saldoproxyserver.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    public User postUser(User user) {
        return userRepository.save(user);
    }


    public void deleteUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User user = new User(optionalUser.get().getUsername(), optionalUser.get().getBalance());
        userRepository.delete(user);
    }


    public User getUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User user = new User(optionalUser.get().getUsername(), optionalUser.get().getBalance());
        return user;
    }


    public User updateBalance(long id, Book book) {
        // search by id the user that has introduced the book
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User user = new User(optionalUser.get().getUsername(), optionalUser.get().getBalance());

        // calculate the rise in balance
        int increaseBalance = calculateBalance(book);
        int previousBalance = user.getBalance();
        int updatedBalance = previousBalance + increaseBalance;

        // assign the new balance to the desired user
        user.setBalance(updatedBalance);
        user.setId(id);
        userRepository.save(user);
        return user;
    }


    public User smallerBalance(long id, Book book) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User user = new User(optionalUser.get().getUsername(), optionalUser.get().getBalance());

        // calculate the rise in balance
        int decreaseBalance = calculateBalance(book);
        int previousBalance = user.getBalance();
        int updatedBalance = previousBalance - decreaseBalance;

        // assign the new balance to the desired user
        user.setBalance(updatedBalance);
        user.setId(id);
        userRepository.save(user);
        return user;
    }


    private int calculateBalance(Book book) {
        int balance;
        if(book.getNumberOfPages() < 100){
            return balance = 10;
        } else if (book.getNumberOfPages() > 100 && book.getNumberOfPages() < 250) {
            return balance = 20;
        } else if (book.getNumberOfPages() > 250 && book.getNumberOfPages() < 500) {
            return balance = 50;
        } else{
            return 100;
        }
    }

    public List<Book> getBookList(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optionalUser.get().getBookList();
    }


    public List<Book> addToBookList(Book book, long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        optionalUser.get().getBookList().add(book);
        return optionalUser.get().getBookList();
    }
}
