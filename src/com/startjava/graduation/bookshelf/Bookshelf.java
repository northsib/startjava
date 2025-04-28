package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exceptions.BookNotFoundException;
import com.startjava.graduation.bookshelf.exceptions.BookshelfFullException;

public class Bookshelf {
    private static final int CAPACITY = 10;
    private static final int MIN_WIDTH = 40;
    private Book[] books = new Book[CAPACITY];
    private int booksCount = 0;

    public void addBook(Book book) {
        if (booksCount < CAPACITY) {
            books[booksCount] = book;
            booksCount++;
            System.out.println("Книга добавлена");
            return;
        }
        throw new BookshelfFullException("Книга не добавлена, книжный шкаф полон");
    }

    public void removeBook(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                books[i] = null;
                shiftBooks(i);
                System.out.println("Книга удалена");
                return;
            }
        }
        throw new BookNotFoundException("Указанная Вами книга не найдена");
    }

    public String findBook(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                System.out.print("Результат поиска: ");
                return books[i].toString();
            }
        }
        throw new BookNotFoundException("Указанная Вами книга не найдена");
    }

    public void displayAllBooks() {
        System.out.println("Список книг в книжном шкафу: ");
        for (int i = 0; i < booksCount; i++) {
            System.out.println((i + 1) + ". " + books[i].toString());
        }
    }

    public void displayBooksCount() {
        System.out.println("Количество книг в шкафу: " + booksCount);
    }

    public void clear() {
        books = new Book[CAPACITY];
        booksCount = 0;
        System.out.println("Книжный шкаф очищен");
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
                System.out.printf("|%-" + maxTitleLength + "s|%n", books[i].toString());
                System.out.println(shelfCreator);
            }
        }
    }

    public void printMainMenu() {
        if (booksCount == 0) {
            System.out.println("Книжный шкаф пуст: Вы можете добавить в него первую книгу");
        }
        for (MenuOptions option : MenuOptions.values()) {
            System.out.println(option.getValue() + ". " + option.getDescription());
        }
        System.out.print("Введите в консоль требуемое значение меню: ");
    }

    private void shiftBooks(int index) {
        System.arraycopy(books, index + 1, books, index, booksCount - index - 1);
        booksCount--;
        books[booksCount] = null;
    }

    private int findMaxTitleLength() {
        int maxLength = MIN_WIDTH;
        for (int i = 0; i < booksCount; i++) {
            char[] titleChars = books[i].toString().toCharArray();
            int tempLength = titleChars.length;
            if (tempLength > maxLength) {
                maxLength = tempLength;
            }
        }
        return maxLength;
    }
}