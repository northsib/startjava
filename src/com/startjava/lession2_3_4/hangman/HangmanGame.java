package com.startjava.lession2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private String[] gallowsFigure = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private final String secretWord;
    private String maskedWord;
    private StringBuilder usedLetters;
    private int attemptsLeft;
    Scanner scanner;


    public HangmanGame() {
        secretWord = selectRandomWord().toUpperCase();
        maskedWord = "_".repeat(secretWord.length());
        usedLetters = new StringBuilder();
        attemptsLeft = gallowsFigure.length;
        scanner = new Scanner(System.in);
    }

    private String selectRandomWord() {
        String[] words = {"Перекресток", "Путешествие", "Снегопад", "Библиотека", "Преподаватель",
                "Консерватория", "Электричка", "Фотография", "Вокзал", "Автомобиль"};
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    public void play() {
        while (true) {
            startMessage();
            makeGuess(inputAndCheckLetter());
            if (isGameWon()) {
                System.out.println("Вы выиграли! Загаданное слово: " + secretWord);
                break;
            }
            if (attemptsLeft == 0) {
                System.out.println("Игра окончена. Загаданное слово: " + secretWord);
                break;
            }
        }
    }

    private void startMessage() {
        System.out.println("Загаданное слово: " + maskedWord +
                "\nКоличество попыток: " + attemptsLeft);
        if (usedLetters.isEmpty()) {
            return;
        }
        System.out.println("Использованные буквы: " + usedLetters.toString().trim());
    }

    private char inputAndCheckLetter() {
        System.out.print("Введите букву (А - Я): ");
        while (true) {
            char guess = Character.toUpperCase(scanner.next().charAt(0));
            if (guess < 'А' || guess > 'Я') {
                System.out.print("Некорректный ввод (допустимо: буквы на кириллице от А до Я). " +
                        "\nВведите другую букву: ");
                continue;
            }
            return guess;
        }
    }

    private void makeGuess(char guess) {
        guess = Character.toUpperCase(guess);
        if (!isValidInput(guess)) {
            return;
        }
        if (!isUsedLetter(guess)) {
            findGuess(guess);
            displayGallowsFigure();
        }
    }

    private boolean isValidInput(char guess) {
        if (guess < 'А' || guess > 'Я') {
            System.out.println("Некорректный ввод (допустимо: буквы на кириллице от А до Я)\n");
            return false;
        }
        return true;
    }

    private boolean isUsedLetter(char guess) {
        String currentUsedLetters = usedLetters.toString();
        if (currentUsedLetters.indexOf(guess) == -1) {
            usedLetters.append(guess).append(" ");
            return false;
        }
        System.out.println("Вы уже вводили букву " + guess + "\n");
        return true;
    }

    private void findGuess(char guess) {
        if (secretWord.indexOf(guess) != -1) {
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    maskedWord = maskedWord.substring(0, i) + guess + maskedWord.substring(i + 1);
                }
            }
            System.out.println("Вы угадали букву!");
            if (attemptsLeft < gallowsFigure.length) {
                attemptsLeft++;
            }
        } else {
            attemptsLeft--;
            System.out.println("Вы не угадали букву. Осталось попыток: " + attemptsLeft);
        }
    }

    private void displayGallowsFigure() {
        for (int i = 0; i < gallowsFigure.length - attemptsLeft; i++) {
            System.out.println(gallowsFigure[i]);
        }
        System.out.println();
    }

    private boolean isGameWon() {
        return maskedWord.equals(secretWord);
    }
}