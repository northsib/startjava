package com.startjava.graduation.bookshelf;

public class Book {
    private String author;
    private String title;
    private int year;

    public Book(String author, String bookName, int year) {
        this.title = bookName;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + year;
    }
}

