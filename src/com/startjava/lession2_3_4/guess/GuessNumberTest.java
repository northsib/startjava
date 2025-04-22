package com.startjava.lession2_3_4.guess;

import java.util.Scanner; 

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerChoose = "yes";
        while (!playerChoose.equals("no")) {
            if (playerChoose.equals("yes")) {
                GuessNumber game = new GuessNumber(createPlayers(scanner));
                game.play();
                System.out.println("Хотите продолжить игру? [yes/no]:");
            } else {
                System.out.println("Введите корректный ответ [yes/no]:");
            }
            playerChoose = scanner.nextLine().toLowerCase();
        }
        scanner.close();
    }

    private static Player[] createPlayers(Scanner scanner) {
        Player[] players = new Player[GuessNumber.PLAYERS_COUNT];
        for (int i = 1; (i - 1) < GuessNumber.PLAYERS_COUNT; i++) {
            System.out.print("Введите имя игрока " + i + ": ");
            players[i - 1] = new Player(scanner.nextLine());
        }
        return players;
    }
}