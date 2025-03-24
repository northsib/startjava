package com.startjava.lession2_3_4.hangman;

import java.util.Random;

public class HangmanGame {
    private static final String[] HANG = {
            "_______",
            "|     |",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private String secretWord;
    private String maskedWord;
    private static boolean[] guessedLetters;
    private int attemptsLeft;

    public HangmanGame() {
        secretWord = getRandomWord().toUpperCase();
        maskedWord = "_".repeat(secretWord.length());
        guessedLetters = new boolean['Я' - 'А' + 1];
        attemptsLeft = HANG.length;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public String getMaskedWord() {
        return maskedWord;
    }

    public void makeGuess(char guess) {
        guess = Character.toUpperCase(guess);

        if (guessedLetters[getLetterIndex(guess)]) {
            System.out.println("Вы уже вводили такую букву");
            return;
        }
        guessedLetters[getLetterIndex(guess)] = true;

        if (secretWord.indexOf(guess) != -1) {
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    maskedWord = maskedWord.substring(0, i) + guess + maskedWord.substring(i + 1);
                }
            }
            System.out.println("Угадал");
        } else {
            attemptsLeft--;
            System.out.println("Не угадал, осталось попыток: " + attemptsLeft);
            displayHang();
        }
        System.out.println();
    }

    public static String getUsedLetters() {
        StringBuilder usedLetters = new StringBuilder();
        for (int i = 0; i < guessedLetters.length; i++) {
            if (guessedLetters[i]) {
                usedLetters.append((char) ('А' + i)).append(" ");
            }
        }
        return usedLetters.toString().trim();
    }

    public boolean isGameWon() {
        return maskedWord.equals(secretWord);
    }

    private int getLetterIndex(char guess) {
        return guess - 'А';
    }

    // Простая проверка кириллических символов
    private boolean isValid(char guess) {
        return (guess >= 'а' && guess <= 'я') || (guess >= 'А' && guess <= 'Я');
    }

    public void displayHang() {
        for (int i = 0; i < HANG.length - attemptsLeft; i++) {
            System.out.println(HANG[i]);
        }
    }

    private String getRandomWord() {
        String[] words = {"Перекрёсток", "Путешествие", "Снегопад", "Библиотека", "Преподаватель",
                "Консерватория", "Электричка", "Фотография", "Вокзал", "Автомобиль"};
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}