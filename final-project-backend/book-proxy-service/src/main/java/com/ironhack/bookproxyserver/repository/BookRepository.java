package com.ironhack.bookproxyserver.repository;

import com.ironhack.bookproxyserver.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value ="SELECT * FROM book", nativeQuery = true)
    List<Book> findAvailableBooks();
}
