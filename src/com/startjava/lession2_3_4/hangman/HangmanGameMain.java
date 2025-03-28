package com.startjava.lession2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerChoose = "yes";
        while (playerChoose.equals("yes")) {
            HangmanGame game = new HangmanGame();
            game.play();
            do {
                System.out.print("Хотите начать новую игру? [yes/no]: ");
                playerChoose = scanner.nextLine().toLowerCase();
            } while (!playerChoose.equals("yes") && !playerChoose.equals("no"));
        }
        scanner.close();
    }
}
