package com.ironhack.edgeservice.model;


import com.ironhack.edgeservice.enums.Genre;


public class Book {


    private long id;
    private String title;
    private int numberOfPages;
    private Genre genre;
    private String writer;

    public Book() {
    }

    public Book(String title, int numberOfPages, Genre genre, String writer) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.writer = writer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
