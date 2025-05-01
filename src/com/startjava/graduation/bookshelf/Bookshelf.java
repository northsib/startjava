package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exceptions.BookNotFoundException;
import com.startjava.graduation.bookshelf.exceptions.BookshelfFullException;
import java.util.Arrays;

public class Bookshelf {
    private static final int CAPACITY = 5;
    private Book[] books = new Book[CAPACITY];
    private int booksCount = 0;
    private int bookshelfLength = 0;

    public Book[] getBooks() {
        return books;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public int getBookshelfLength() {
        return bookshelfLength;
    }

    public int getFreeShelves() {
        return CAPACITY - booksCount;
    }

    public void addBook(Book book) {
        if (booksCount < CAPACITY) {
            books[booksCount] = book;
            booksCount++;
            if (book.toString().length() > bookshelfLength) {
                bookshelfLength = updateShelvesLength();
            }
            return;
        }
        throw new BookshelfFullException("Книга не добавлена, книжный шкаф полон");
    }

    public void removeBook(String title) {
        for (int i = 0; i < booksCount; i++) {
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
        System.arraycopy(books, index + 1, books, index, booksCount - index - 1);
        booksCount--;
        books[booksCount] = null;
    }

    public Book findBook(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        throw new BookNotFoundException("Указанная Вами книга не найдена");
    }

    public void clear() {
        Arrays.fill(books, 0, booksCount - 1, null);
        booksCount = 0;
    }

    private int updateShelvesLength() {
        int newBookshelfLength = 0;
        for (int i = 0; i < booksCount; i++) {
            newBookshelfLength = Math.max(newBookshelfLength, books[i].toString().length());
        }
        return newBookshelfLength;
    }
}