package com.startjava.lession2_3_4.guess;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int PLAYERS_COUNT = 3;
    private static final int ROUNDS_COUNT = 3;
    private Player[] players;
    private int guessNumber;
    private Scanner scanner;

    public GuessNumber(Player[] players) {
        this.players = players;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        welcomeMessage();
        castLots(players);
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            System.out.println("Начинается раунд № " + (i + 1));
            guessNumber = (int) (Math.random() * 100) + 1;
            for (int j = 1; j <= Player.ATTEMPTS_COUNT; j++) {
                boolean isEndGame = false;
                for (int k = 0; k < PLAYERS_COUNT; k++) {
                    System.out.print("Попытка " + j +
                            "\nЧисло вводит " + players[k].getName() + ": ");
                    int inputNumber = inputNumber(players[k]);
                    if (checkGuess(inputNumber)) {
                        printWinGameMessage(players[k]);
                        isEndGame = true;
                        break;
                    }
                    if (players[k].getCurrentAttempt() > Player.ATTEMPTS_COUNT) {
                        System.out.println("У " + players[k].getName() + " закончились попытки!");
                    }
                }
                if (isEndGame || j == Player.ATTEMPTS_COUNT) {
                    resetPlayersAttempts();
                    break;
                }
            }
            if (players[i].getRemainingAttempts() < 0) {
                printLoseGameMessage();
            }
        }
        findWinner();
    }

    private static void welcomeMessage() {
        System.out.println("Игра началась! У каждого игрока по " + Player.ATTEMPTS_COUNT + " попыток");
    }

    private void castLots(Player[] players) {
        Random random = new Random();
        System.out.println("Жребий ! ! !");

        for (int i = players.length - 1; i > 0; i--) {
            int j = random.nextInt(PLAYERS_COUNT);
            if (i != j) {
                Player temp = players[i];
                players[i] = players[j];
                players[j] = temp;
            }
        }
        System.out.println("Жребий выиграл " + players[0].getName());
    }

    private int inputNumber(Player player) {
        while (true) {
            try {
                int inputNumber = scanner.nextInt();
                player.addNumber(inputNumber);
                return inputNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage() + "\nПопробуйте еще раз: ");
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: некорректный ввод числа\nПопробуйте еще раз: ");
                scanner.nextLine();
            }
        }
    }

    private boolean checkGuess(int inputNumber) {
        if (inputNumber == guessNumber) {
            return true;
        }
        System.out.println(inputNumber + (inputNumber > guessNumber ? " больше" : " меньше") +
                ", чем загаданное число");
        return false;
    }

    private void printLoseGameMessage() {
        System.out.println("Игра окончена! Никто не выиграл");
        printAllPlayersNumbers();
    }

    private void printWinGameMessage(Player player) {
        System.out.println("Поздравляем! Игрок " + player.getName() +
                " отгадал загаданное число - " + guessNumber +
                " c " + (player.getCurrentAttempt() - 1) + "-й попытки");
        player.upScore();
        printAllPlayersNumbers();
    }

    private void printAllPlayersNumbers() {
        for (Player player : players) {
            printPlayerGuessedNumbers(player);
        }
    }

    private void printPlayerGuessedNumbers(Player player) {
        int[] guessedNumbers = player.getAttempts();
        System.out.println("Числа названные " + player.getName() + ": ");

        for (int i = 0; i < guessedNumbers.length; i++) {
            if (i == 4) {
                System.out.println();
            }
            if (i == 7) {
                System.out.println();
            }
            System.out.print(guessedNumbers[i] + " ");
        }
        System.out.println();
    }

    private void resetPlayersAttempts() {
        for (Player player : players) {
            player.resetCurrentAttempt();
        }
    }

    private void findWinner() {
        Player[] sortedByWinPlayers = Arrays.copyOf(players, PLAYERS_COUNT);
        for (int i = 0; i < sortedByWinPlayers.length; i++) {
            for (int j = 0; j < sortedByWinPlayers.length - i - 1; j++) {
                if (sortedByWinPlayers[j].getScore() < sortedByWinPlayers[j + 1].getScore()) {
                    Player temp = sortedByWinPlayers[j];
                    sortedByWinPlayers[j] = sortedByWinPlayers[j + 1];
                    sortedByWinPlayers[j + 1] = temp;
                }
            }
        }
        if (sortedByWinPlayers[0].getScore() == 0) {
            System.out.println("Никто из игроков не смог победить");
            return;
        }
        if (checkDraw(sortedByWinPlayers)) {
            return;
        }
        System.out.println("Победу в трёх раундах одержал " + sortedByWinPlayers[0].getName() +
                " набрав " + sortedByWinPlayers[0].getScore() + " очков!");
    }

    private boolean checkDraw(Player[] sortedByWinPlayers) {
        if (sortedByWinPlayers[0].getScore() == sortedByWinPlayers[1].getScore() &&
                sortedByWinPlayers[1].getScore() == sortedByWinPlayers[2].getScore()) {
            System.out.println("Ничья, все игроки набрали одинаковое количество очков - " +
                    sortedByWinPlayers[0].getScore());
            return true;
        }
        if (sortedByWinPlayers[0].getScore() == sortedByWinPlayers[1].getScore()) {
            System.out.println("Ничья, " + sortedByWinPlayers[0].getName() + " и " +
                    sortedByWinPlayers[1].getName() + " набрали одинаковое количество очков - " +
                    sortedByWinPlayers[0].getScore());
            return true;
        }
        return false;
    }
}