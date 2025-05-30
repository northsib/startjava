package com.startjava.graduation.bookshelf;

public class Book {
    private String author;
    private String title;
    private int publicationYear;

    public Book(String author, String title, int publicationYear) {
        this.title = title;
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

