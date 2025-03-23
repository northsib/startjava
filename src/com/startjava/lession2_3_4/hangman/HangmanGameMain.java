package com.startjava.lession2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame("Мирослав");
        while (!game.isGameWon() && game.getAttemptsLeft() > 0) {
            char guess = getUserInput();
            game.makeGuess(guess);
            System.out.println("загаданное слово - " + game.getMaskedWord());
        }
        if (game.isGameWon()) {
            System.out.println("Вы выиграли!");
        } else {
            System.out.println("Игра окончена. Загаданное слово: " + game.getSecretWord());
        }
    }

    public static char getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву (А - я): ");
        return scanner.next().charAt(0);
    }
}
