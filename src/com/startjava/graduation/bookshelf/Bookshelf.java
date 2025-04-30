package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exceptions.BookNotFoundException;
import com.startjava.graduation.bookshelf.exceptions.BookshelfFullException;
import java.util.Arrays;

public class Bookshelf {
    private static final int CAPACITY = 2;
    private Book[] books = new Book[CAPACITY];
    private int booksCount = 0;

    public int getBooksCount() {
        return booksCount;
    }

    public void addBook(Book book) {
        if (booksCount < CAPACITY) {
            books[booksCount] = book;
            booksCount++;
            return;
        }
        throw new BookshelfFullException("Книга не добавлена, книжный шкаф полон");
    }

    public void removeBook(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                shiftBooks(i);
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
        Arrays.fill(books, null);
        booksCount = 0;
    }

    public void displayBookshelfStatus() {
        if (booksCount == 0) {
            return;
        }
        System.out.println("В шкафу книг - " + booksCount +
                ", свободно полок - " + (CAPACITY - booksCount) + "\n");

        StringBuilder shelfCreator = new StringBuilder();
        int maxTitleLength = findMaxTitleLength();

        shelfCreator.append("|").append("-".repeat(maxTitleLength)).append("|");

        for (int i = 0; i < CAPACITY; i++) {
            if (books[i] != null) {
                System.out.printf("|%-" + maxTitleLength + "s|%n", books[i]);
                System.out.println(shelfCreator);
            }
        }
    }

    private int findMaxTitleLength() {
        int maxLength = books[0].toString().length();
        for (int i = 0; i < booksCount; i++) {
            int tempLength = books[i].toString().length();
            if (tempLength > maxLength) {
                maxLength = tempLength;
            }
        }
        return maxLength;
    }
}