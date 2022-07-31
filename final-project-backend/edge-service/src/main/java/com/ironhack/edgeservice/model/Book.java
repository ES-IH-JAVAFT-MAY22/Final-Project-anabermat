package com.ironhack.edgeservice.model;





public class Book {


    private long id;
    private String title;
    private int numberOfPages;
    private String writer;

    public Book() {
    }

    public Book(String title, int numberOfPages, String writer) {
        this.title = title;
        this.numberOfPages = numberOfPages;
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


    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
