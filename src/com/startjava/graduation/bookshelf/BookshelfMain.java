package com.startjava.graduation.bookshelf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfMain {
    public static void main(String[] args) throws InterruptedException {
        Bookshelf bookshelf = new Bookshelf();
        boolean isActive = true;
        Scanner scanner = new Scanner(System.in);
        welcomeMessage();

        while (isActive) {
            printMainMenu(bookshelf);
            int choice = userMenuInput(scanner);
            scanner.nextLine();
            try {
                MenuOptions option = MenuOptions.getByValue(choice);

                switch (option) {
                    case ADD_BOOK:
                        String title = bookTitleInput(scanner);
                        System.out.print("Введите автора: ");
                        String author = scanner.nextLine();
                        int year = bookYearInput(scanner);
                        bookshelf.addBook(new Book(author, title, year));
                        System.out.println("Книга добавлена");
                        break;
                    case REMOVE_BOOK:
                        String bookToRemove = bookTitleInput(scanner);
                        bookshelf.removeBook(bookToRemove);
                        System.out.println("Книга удалена");
                        break;
                    case FIND_BOOK:
                        String bookToFind = bookTitleInput(scanner);
                        System.out.println("Результат поиска: " + bookshelf.findBook(bookToFind));
                        break;
                    case CLEAR_SHELF:
                        bookshelf.clear();
                        System.out.println("Книжный шкаф очищен");
                        break;
                    case EXIT:
                        isActive = false;
                        break;
                    default:
                        throw new IllegalArgumentException("Введенный Вами номер " +
                                "не соответствует пункту меню!");
                }
            } catch (RuntimeException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
            if (isActive) {
                displayBookshelf(bookshelf);
                wait(scanner);
            }
        }
        scanner.close();
    }

    private static void welcomeMessage() throws InterruptedException {
        String message = "Добро пожаловать в программу \"Книжный шкаф\"";
        char[] chars = message.toCharArray();
        for (char symbols : chars) {
            System.out.print(symbols);
            Thread.sleep(100);
        }
        System.out.println();
    }

    private static void printMainMenu(Bookshelf bookshelf) {
        if (bookshelf.getBooksCount() == 0) {
            System.out.println("Книжный шкаф пуст: Вы можете добавить в него первую книгу");
        }
        for (MenuOptions option : MenuOptions.values()) {
            System.out.println(option.getValue() + ". " + option.getDescription());
        }
        System.out.print("Введите в консоль требуемое значение меню: ");
    }

    private static int userMenuInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("Ошибка: для выбора пункта меню введите число!" +
                        "\nВведите число, соответствующее пункту меню: ");
            }
        }
    }

    private static String bookTitleInput(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите название книги: ");
                String title = scanner.nextLine();
                if (title.isBlank()) {
                    throw new IllegalArgumentException("Название книги не должно быть пустым!");
                }
                return title;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static int bookYearInput(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите год: ");
                int year = scanner.nextInt();
                if (year < 0 || year > 2025) {
                    throw new InputMismatchException("Некорректный ввод года издания книги " +
                            "(допустимо: целые числа от 0 до 2025)");
                }
                scanner.nextLine();
                return year;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static void displayBookshelf(Bookshelf bookshelf) {
        if (bookshelf.getBooksCount() == 0) {
            return;
        }
        System.out.println("В шкафу книг - " + bookshelf.getBooksCount() +
                ", свободно полок - " + bookshelf.getFreeShelves() + "\n");

        StringBuilder shelf = new StringBuilder();
        shelf.append("|").append("-".repeat(bookshelf.getBookshelfLength())).append("|");

        for (Book book : bookshelf.getBooks()) {
            if (book != null) {
                System.out.printf("|%-" + bookshelf.getBookshelfLength() + "s|%n", book);
                System.out.println(shelf);
            }
        }
    }

    private static void wait(Scanner scanner) {
        System.out.println("Для продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }
}
