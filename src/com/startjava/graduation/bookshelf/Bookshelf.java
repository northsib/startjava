package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exceptions.BookNotFoundException;
import com.startjava.graduation.bookshelf.exceptions.BookshelfFullException;
import java.util.Arrays;

public class Bookshelf {
    private static final int CAPACITY = 5;
    private Book[] books = new Book[CAPACITY];
    private int bookCount = 0;
    private int bookshelfLength = 0;

    public Book[] getBooks() {
        return Arrays.copyOf(books, bookCount);
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getBookshelfLength() {
        return bookshelfLength;
    }

    public int getFreeShelves() {
        return CAPACITY - bookCount;
    }

    public void addBook(Book book) {
        if (bookCount >= CAPACITY) {
            throw new BookshelfFullException("Книга не добавлена, книжный шкаф полон");
        }
        books[bookCount] = book;
        bookCount++;
        if (book.toString().length() > bookshelfLength) {
            bookshelfLength = updateShelvesLength();
        }
    }

    public void removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(title)) {
                int removedLength = books[i].toString().length();
                shiftBooks(i);
                if (removedLength == bookshelfLength) {
                    bookshelfLength = updateShelvesLength();
                }
                return;
            }
        }
        throw new BookNotFoundException("Указанная Вами книга не найдена");
    }

    private void shiftBooks(int index) {
        System.arraycopy(books, index + 1, books, index, bookCount - index - 1);
        bookCount--;
        books[bookCount] = null;
    }

    public Book findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    public void clear() {
        Arrays.fill(books, 0, bookCount - 1, null);
        bookCount = 0;
        bookshelfLength = 0;
    }

    private int updateShelvesLength() {
        int newBookshelfLength = 0;
        for (int i = 0; i < bookCount; i++) {
            newBookshelfLength = Math.max(newBookshelfLength, books[i].toString().length());
        }
        return newBookshelfLength;
    }
}