package com.startjava.lession2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] HANG = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private final String secretWord;
    private String maskedWord;
    private static boolean[] usedLetters;
    private int attemptsLeft;

    public HangmanGame() {
        secretWord = getRandomWord().toUpperCase();
        maskedWord = "_".repeat(secretWord.length());
        usedLetters = new boolean['Я' - 'А' + 1];
        attemptsLeft = HANG.length;
    }

    public void play() {
        while (true) {
            System.out.println("Загаданное слово - " + maskedWord +
                    "\nКоличество попыток - " + attemptsLeft);
            if (!getUsedLetters().isEmpty()) {
                System.out.println("Использованные буквы: " + getUsedLetters());
            }
            char guess = getUserInput();
            makeGuess(guess);
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

    private String getRandomWord() {
        String[] words = {"Перекресток", "Путешествие", "Снегопад", "Библиотека", "Преподаватель",
                "Консерватория", "Электричка", "Фотография", "Вокзал", "Автомобиль"};
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    private static String getUsedLetters() {
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < usedLetters.length; i++) {
            if (usedLetters[i]) {
                letters.append((char) ('А' + i)).append(" ");
            }
        }
        return letters.toString().trim();
    }

    private char getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву (А - Я): ");
        return scanner.next().charAt(0);
    }

    private void makeGuess(char guess) {
        guess = Character.toUpperCase(guess);
        if (!isValidInput(guess)) {
            return;
        }
        if (!isUsedLetter(guess)) {
            return;
        }
        findGuess(guess);
        displayHang();
    }

    private boolean isValidInput(char guess) {
        if (guess < 'А' || guess > 'Я') {
            System.out.println("Некорректный ввод (допустимо: буквы на кириллице от А до Я)\n");
            return false;
        }
        return true;
    }

    private boolean isUsedLetter(char guess) {
        int guessIndex = guess - 'А';
        if (!usedLetters[guessIndex]) {
            return usedLetters[guessIndex] = true;
        } else {
            System.out.println("Вы уже вводили букву " + guess + "\n");
            return false;
        }
    }

    private void findGuess(char guess) {
        if (secretWord.indexOf(guess) != -1) {
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    maskedWord = maskedWord.substring(0, i) + guess + maskedWord.substring(i + 1);
                }
            }
            System.out.println("Вы угадали букву!");
            if (attemptsLeft < HANG.length) {
                attemptsLeft++;
            }
        } else {
            attemptsLeft--;
            System.out.println("Вы не угадали букву. Осталось попыток: " + attemptsLeft);
        }
    }

    private void displayHang() {
        for (int i = 0; i < HANG.length - attemptsLeft; i++) {
            System.out.println(HANG[i]);
        }
        System.out.println();
    }

    private boolean isGameWon() {
        return maskedWord.equals(secretWord);
    }
}