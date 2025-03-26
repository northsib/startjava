package com.startjava.lession2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerChoose = "yes";
        while (playerChoose.equals("yes")) {
            HangmanGame game = new HangmanGame();
            game.play();
            System.out.println("Хотите начать новую игру игру? [yes/no]:");
            playerChoose = scanner.nextLine().toLowerCase();
            while (true) {
                if (playerChoose.equals("yes") || playerChoose.equals("no")) {
                    break;
                } else {
                    System.out.println("Некорректный ввод, пожалуйста введите \"yes\" или \"no\"");
                    playerChoose = scanner.nextLine().toLowerCase();
                }
            }
        }
        scanner.close();
    }
}
