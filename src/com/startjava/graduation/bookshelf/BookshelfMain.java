package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfMain {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        boolean isActive = true;
        Scanner scanner = new Scanner(System.in);

        while (isActive) {
            Bookshelf.printMainMenu();
            int choice = userInput(scanner);
            switch (choice) {
                case 1:
                    String title = bookTitleInput(scanner);
                    System.out.println("Введите автора: ");
                    String author = scanner.nextLine();
                    System.out.println("Введите год: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    bookshelf.addBook(new Book(author, title, year));
                    break;
                case 2:
                    String bookToRemove = bookTitleInput(scanner);
                    bookshelf.removeBook(bookToRemove);
                    break;
                case 3:
                    String bookToFind = bookTitleInput(scanner);
                    System.out.println(bookshelf.findBook(bookToFind));
                    break;
                case 4:
                    bookshelf.displayAllBooks();
                    break;
                case 5:
                    bookshelf.displayBooksCount();
                    break;
                case 6:
                    bookshelf.displayFreeShelf();
                    break;
                case 7:
                    bookshelf.clear();
                    break;
                case 8:
                    isActive = false;
                    break;
                default:
                    System.out.println("Введите число, соответствующее пункту меню!");
                    break;
            }
            wait(scanner);
        }
        scanner.close();
    }

    private static int userInput(Scanner scanner) {
        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= 1 && choice <= 8) {
                return choice;
            }
            System.out.println("Введите число, соответствующее пункту меню!");
        }
    }

    private static String bookTitleInput(Scanner scanner) {
        System.out.println("Введите название книги: ");
        return scanner.nextLine();
    }

    private static void wait(Scanner scanner) {
        System.out.println("Для продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }
}
