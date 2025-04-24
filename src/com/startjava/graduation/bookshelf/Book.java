package com.startjava.graduation.bookshelf;

public class Book {
    private String author;
    private String title;
    private int year;
    private boolean isAvailable;

    public Book(String author, String bookName, int year) {
        this.title = bookName;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + year;
    }
}

