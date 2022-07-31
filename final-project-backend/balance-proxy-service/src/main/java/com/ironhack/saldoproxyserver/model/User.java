package com.ironhack.saldoproxyserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id  // indicate that id is the primary column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private int balance;

    @OneToMany(mappedBy = "user")
    private List<Book> bookList;

    public User() {
    }

    public User(String username, int balance) {
        this.username = username;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
