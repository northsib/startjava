package com.startjava.lession2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private final String[] gallows = {
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
    private Scanner scanner;

    public HangmanGame() {
        secretWord = selectRandomWord().toUpperCase();
        maskedWord = "_".repeat(secretWord.length());
        usedLetters = new StringBuilder();
        attemptsLeft = gallows.length;
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
            findGuess(inputLetter());
            displayGallowsFigure();
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

    private char inputLetter() {
        System.out.print("Введите букву (А - Я): ");
        while (true) {
            char guess = Character.toUpperCase(scanner.next().charAt(0));
            if (guess < 'А' || guess > 'Я') {
                System.out.print("Некорректный ввод (допустимо: буквы на кириллице от А до Я). " +
                        "\nВведите другую букву: ");
                continue;
            }
            if (isUsedLetter(guess)) {
                System.out.print("Вы уже вводили букву " + guess + "\nВведите другую букву: ");
                continue;
            }
            return guess;
        }
    }

    private boolean isUsedLetter(char guess) {
        if (usedLetters.toString().indexOf(guess) == -1) {
            usedLetters.append(guess).append(" ");
            return false;
        }
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
            if (attemptsLeft < gallows.length) {
                attemptsLeft++;
            }
            return;
        }
        attemptsLeft--;
        System.out.println("Вы не угадали букву. Осталось попыток: " + attemptsLeft);
    }

    private void displayGallowsFigure() {
        for (int i = 0; i < gallows.length - attemptsLeft; i++) {
            System.out.println(gallows[i]);
        }
        System.out.println();
    }

    private boolean isGameWon() {
        return maskedWord.equals(secretWord);
    }
}