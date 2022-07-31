package com.ironhack.bookproxyserver.service.impl;

import com.ironhack.bookproxyserver.model.Book;
import com.ironhack.bookproxyserver.repository.BookRepository;
import com.ironhack.bookproxyserver.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book postBook(Book book) {
        return bookRepository.save(book);
    }


    public void deleteBook(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(!optionalBook.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Book book = new Book(optionalBook.get().getTitle(),optionalBook.get().getNumberOfPages(),
                optionalBook.get().getWriter());
        bookRepository.delete(book);
    }


    public Book getBook(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(!optionalBook.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Book book = new Book(optionalBook.get().getTitle(),optionalBook.get().getNumberOfPages(),
                optionalBook.get().getWriter());
        return book;
    }


    public List<Book> findAvailableBooks() {
        return bookRepository.findAvailableBooks();
    }
}
