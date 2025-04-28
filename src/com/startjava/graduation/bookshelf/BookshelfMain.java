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
            bookshelf.printMainMenu();
            int choice = userMenuInput(scanner);
            scanner.nextLine();
            try {
                MenuOptions option = MenuOptions.getByValue(choice);

                switch (option) {
                    case ADD_BOOK:
                        String title = bookTitleInput(scanner);
                        System.out.println("Введите автора: ");
                        String author = scanner.nextLine();
                        int year = bookYearInput(scanner);
                        bookshelf.addBook(new Book(author, title, year));
                        scanner.nextLine();
                        break;
                    case REMOVE_BOOK:
                        String bookToRemove = bookTitleInput(scanner);
                        bookshelf.removeBook(bookToRemove);
                        break;
                    case FIND_BOOK:
                        String bookToFind = bookTitleInput(scanner);
                        System.out.println(bookshelf.findBook(bookToFind));
                        break;
                    case DISPLAY_ALL:
                        bookshelf.displayAllBooks();
                        break;
                    case SHOW_COUNT:
                        bookshelf.displayBooksCount();
                        break;
                    case CLEAR_SHELF:
                        bookshelf.clear();
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
                wait(scanner);
                continue;
            }
            if (isActive) {
                bookshelf.displayBookshelfStatus();
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
        System.out.println("Введите название книги: ");
        return scanner.nextLine();
    }

    private static int bookYearInput(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Введите год: ");
                int year = scanner.nextInt();
                if (year < 0 || year > 2025) {
                    throw new InputMismatchException();
                }
                return year;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Ошибка: некорректный ввод года издания книги " +
                        "(допустимо: целые числа от 0 до 2025)");
            }
        }
    }

    private static void wait(Scanner scanner) {
        System.out.println("Для продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }
}
