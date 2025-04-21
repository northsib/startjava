package com.startjava.lession2_3_4.guess;

import java.util.Scanner; 

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerChoose = "yes";
        while (!playerChoose.equals("no")) {
            if (playerChoose.equals("yes")) {
                welcomeMessage();
                GuessNumber game = new GuessNumber(createPlayers(scanner));
                game.play();
                System.out.println("Хотите продолжить игру? [yes/no]:");
            }
            if (!playerChoose.equals("yes")) {
                System.out.println("Введите корректный ответ [yes/no]:");
            }
            playerChoose = scanner.nextLine().toLowerCase();
        }
        scanner.close();
    }

    private static void welcomeMessage() {
        System.out.println("Игра началась! У каждого игрока по " + Player.ATTEMPTS_COUNT + " попыток");
    }

    private static Player[] createPlayers(Scanner scanner) {
        System.out.print("Введите имя игрока 1: ");
        Player player1 = new Player(scanner.nextLine());
        System.out.print("Введите имя игрока 2: ");
        Player player2 = new Player(scanner.nextLine());
        System.out.print("Введите имя игрока 3: ");
        Player player3 = new Player(scanner.nextLine());
        return new Player[] {player1, player2, player3};
    }
}