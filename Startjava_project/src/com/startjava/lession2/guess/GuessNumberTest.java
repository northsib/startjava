package com.startjava.lession2.guess;

import java.util.Scanner; 

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerChoose = "yes";
        while (playerChoose.equals("yes")) {
            System.out.println("Введите имя игрока 1:");
            Player player1 = new Player(scanner.nextLine());
            System.out.println("Введите имя игрока 2:");
            Player player2 = new Player(scanner.nextLine());
            GuessNumber game = new GuessNumber(player1, player2);
            game.play();
            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                playerChoose = scanner.nextLine().toLowerCase();
            } while (!playerChoose.equals("yes") && !playerChoose.equals("no"));
        }
        scanner.close();
    }
}