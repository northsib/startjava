package com.startjava.lession2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        while (!game.isGameWon() && game.getAttemptsLeft() > 0) {
            System.out.println("Загаданное слово - " + game.getMaskedWord());
            if (!HangmanGame.getUsedLetters().isEmpty()) {
                System.out.println("Использованные буквы: " + HangmanGame.getUsedLetters());
            }

            char guess = getUserInput();
            game.makeGuess(guess);
        }
        if (game.isGameWon()) {
            System.out.println("Вы выиграли! Загаданное слово: " + game.getSecretWord());
        } else {
            System.out.println("Игра окончена. Загаданное слово: " + game.getSecretWord());
        }
    }

    public static char getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву (А - Я): ");
        return scanner.next().charAt(0);
    }
}
