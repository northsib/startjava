package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exceptions.BookNotFoundException;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfMain {
    public static void main(String[] args) throws InterruptedException {
        Bookshelf bookshelf = new Bookshelf();
        Scanner scanner = new Scanner(System.in);
        welcomeMessage();
        while (true) {
            printMainMenu(bookshelf);
            try {
                MenuItems item = inputMenuItem(scanner);
                if (item == MenuItems.EXIT) {
                    break;
                }
                switchItem(item, scanner, bookshelf);
            } catch (RuntimeException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
            displayBookshelf(bookshelf);
            wait(scanner);
        }
        scanner.close();
    }

    private static void welcomeMessage() throws InterruptedException {
        String message = "Добро пожаловать в программу \"Книжный шкаф\"";
        for (char ch : message.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(100);
        }
        System.out.println();
    }

    private static void printMainMenu(Bookshelf bookshelf) {
        if (bookshelf.getBookCount() == 0) {
            System.out.println("Книжный шкаф пуст: Вы можете добавить в него первую книгу");
        }
        for (MenuItems item : MenuItems.values()) {
            System.out.println(item.getItemNumber() + ". " + item.getDescription());
        }
    }

    private static MenuItems inputMenuItem(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите в консоль требуемое значение меню: ");
                int userChoice = scanner.nextInt();
                scanner.nextLine();
                return MenuItems.getItem(userChoice);
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: для выбора пункта меню введите число!");
                scanner.nextLine();
            } catch (RuntimeException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static void switchItem(MenuItems item, Scanner scanner, Bookshelf bookshelf) {
        switch (item) {
            case ADD_BOOK:
                add(scanner, bookshelf);
                break;
            case REMOVE_BOOK:
                remove(scanner, bookshelf);
                break;
            case FIND_BOOK:
                find(scanner, bookshelf);
                break;
            case CLEAR_SHELF:
                bookshelf.clear();
                System.out.println("Книжный шкаф очищен");
                break;
            default:
                throw new IllegalArgumentException("Введенный Вами номер " +
                        "не соответствует пункту меню!");
        }
    }

    private static void add(Scanner scanner, Bookshelf bookshelf) {
        String title = inputTitle(scanner);
        System.out.print("Введите автора: ");
        String author = scanner.nextLine();
        int year = inputBookYear(scanner);
        bookshelf.addBook(new Book(author, title, year));
        System.out.println("Книга добавлена");
    }

    private static int inputBookYear(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите год: ");
                int year = scanner.nextInt();
                scanner.nextLine();
                if (year < 0 || year > Year.now().getValue()) {
                    throw new IllegalArgumentException("Некорректный ввод года издания книги " +
                            "(допустимо: целые числа от 0 до 2025)");
                }
                return year;
            } catch (InputMismatchException e) {
                System.out.println("Недопустимый ввод (допустимо: целые числа от 0 до 2025)");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static void remove(Scanner scanner, Bookshelf bookshelf) {
        String title = inputTitle(scanner);
        bookshelf.removeBook(title);
        System.out.println("Книга удалена");
    }

    private static void find(Scanner scanner, Bookshelf bookshelf) {
        String title = inputTitle(scanner);
        if (bookshelf.findBook(title) == null) {
            throw new BookNotFoundException("Указанная Вами книга не найдена");
        }
        System.out.println("Результат поиска: " + bookshelf.findBook(title));
    }

    private static String inputTitle(Scanner scanner) {
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

    private static void displayBookshelf(Bookshelf bookshelf) {
        if (bookshelf.getBookCount() == 0) {
            return;
        }
        System.out.println("В шкафу книг - " + bookshelf.getBookCount() +
                ", свободно полок - " + bookshelf.getFreeShelves() + "\n");

        StringBuilder shelf = new StringBuilder();
        for (Book book : bookshelf.getBooks()) {
            shelf.append("|").append(book.toString())
                    .append(" ".repeat(bookshelf.getBookshelfLength() - book.toString().length()))
                    .append("|").append("\n")
                    .append("|").append("-".repeat(bookshelf.getBookshelfLength()))
                    .append("|").append("\n");
        }
        System.out.println(shelf);
    }

    private static void wait(Scanner scanner) {
        System.out.println("Для продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }
}
