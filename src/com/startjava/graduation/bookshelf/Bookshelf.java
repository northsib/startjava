package com.startjava.graduation.bookshelf;

public class Bookshelf {
    private static final int CAPACITY = 10;
    private Book[] books = new Book[CAPACITY];
    private int booksCount = 0;

    public Bookshelf() {
    }

    public void addBook(Book book) {
        if (booksCount < CAPACITY) {
            books[booksCount] = book;
            booksCount++;
            System.out.println("Книга добавлена");
            return;
        }
        System.out.println("Книжный шкаф полон");
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
        System.out.println("Указанная Вами книга не найдена");
    }

    public String findBook(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                System.out.print("Результат поиска: ");
                return books[i].toString();
            }
        }
        return "Указанная Вами книга не найдена";
    }

    public void displayBooksCount() {
        System.out.println("Количество книг в шкафу: " + booksCount);
    }

    public void displayFreeShelf() {
        System.out.println("Количество свободных мест в шкафу: " + (CAPACITY - booksCount));
    }

    public void clear() {
        books = new Book[CAPACITY];
        booksCount = 0;
        System.out.println("Книжный шкаф очищен");
    }

    public void displayAllBooks() {
        System.out.println("Список книг в книжном шкафу: ");
        for (int i = 0; i < booksCount; i++) {
            System.out.println((i + 1) + ". " + books[i].toString());
        }
    }

    private void shiftBooks(int index) {
        System.arraycopy(books, index + 1, books, index, booksCount - index - 1);
        booksCount--;
        books[booksCount] = null;
    }

    public static void printMainMenu() {
        System.out.print("""
                Меню:
                1.Добавить книгу
                2.Удалить книгу
                3.Найти книгу
                4.Показать все книги
                5.Показать количество книг
                6.Показать количество свободных полок
                7.Очистить шкаф
                8.Выйти
                Введите в консоль требуемое действие:\s""");
    }
}
