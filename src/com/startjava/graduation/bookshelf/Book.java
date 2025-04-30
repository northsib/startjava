package com.startjava.graduation.bookshelf;

public class Book {
    private String author;
    private String title;
    private int publicationYear;

    public Book(String author, String bookName, int publicationYear) {
        this.title = bookName;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + publicationYear;
    }
}

