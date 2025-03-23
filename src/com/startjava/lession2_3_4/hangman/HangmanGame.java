package com.startjava.lession2_3_4.hangman;

public class HangmanGame {
    private String secretWord;
    private String maskedWord;
    private boolean[] guessedLetters;
    private int attemptsLeft;
    private static final String[] HANG = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };

    public HangmanGame(String word) {
        secretWord = word.toLowerCase();
        maskedWord = "_".repeat(secretWord.length());
        guessedLetters = new boolean['я' - 'А'];
        attemptsLeft = 6;
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
        guess = Character.toLowerCase(guess);
        if (secretWord.indexOf(guess) != -1) {
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    maskedWord = maskedWord.substring(0, i) + guess + maskedWord.substring(i + 1);
                }
            }
            guessedLetters[getLetterIndex(guess)] = true;
            System.out.println("Угадал");
        } else {
            attemptsLeft--;
            System.out.println("Не угадал");
            displayHang();
        }
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
}
