package com.startjava.lession2_3_4.guess;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int PLAYERS_COUNT = 3;
    private static final int ROUNDS_COUNT = 3;

    private int guessNumber;
    private Player[] players;
    private int currentPlayerIndex = 0;
    private Player currentPlayer;
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
            while (currentPlayer.getRemainingAttempts() >= 0) {
                System.out.print("Попытка " + currentPlayer.getCurrentAttempt() +
                        "\nЧисло вводит " + currentPlayer.getName() + ": ");
                int inputNumber = inputNumber();
                if (checkGuess(inputNumber)) {
                    printWinGameMessage();
                    break;
                }
                if (currentPlayer.getCurrentAttempt() > Player.ATTEMPTS_COUNT) {
                    System.out.println("У " + currentPlayer.getName() + " закончились попытки!");
                }
                switchPlayer();
            }
            if (currentPlayer.getRemainingAttempts() < 0) {
                printLoseGameMessage();
            }
            resetPlayersAttempts();
            currentPlayer = players[0];
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
        currentPlayer = players[0];
        System.out.println("Жребий выиграл " + currentPlayer.getName());
    }

    private int inputNumber() {
        while (true) {
            try {
                int inputNumber = scanner.nextInt();
                return currentPlayer.addNumber(inputNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage() + "\nПопробуйте еще раз: ");
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
        System.out.println(inputNumber + (inputNumber > guessNumber ? " больше, чем загаданное число" :
                " меньше, чем загаданное число"));
        return false;
    }

    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % PLAYERS_COUNT;
        currentPlayer = players[currentPlayerIndex];
    }

    private void printLoseGameMessage() {
        System.out.println("Игра окончена! Никто не выиграл");
        printAllPlayersNumbers();
    }

    private void printWinGameMessage() {
        System.out.println("Поздравляем! Игрок " + currentPlayer.getName() +
                " отгадал загаданное число - " + guessNumber +
                " c " + (currentPlayer.getCurrentAttempt() - 1) + "-й попытки");
        currentPlayer.addScore();
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
        int[] playersScores = new int[PLAYERS_COUNT];
        for (int i = 0; i < PLAYERS_COUNT; i++) {
            playersScores[i] = players[i].getScore();
        }
        int maxScore = Math.max(Math.max(playersScores[0], playersScores[1]), playersScores[2]);
        if (maxScore == 0) {
            System.out.println("Никто из игроков не смог победить");
            return;
        }

        if (!checkDraw(playersScores)) {
            for (int i = 0; i < PLAYERS_COUNT; i++) {
                if (playersScores[i] == maxScore) {
                    System.out.println("Победу в трёх раундах одержал " + players[i].getName());
                }
            }
        }
    }

    private boolean checkDraw(int[] playersScores) {
        if (playersScores[0] == playersScores[1] && playersScores[0] > playersScores[2]) {
            System.out.println("Ничья, " + players[0].getName() + " и " +
                    players[1].getName() + " набрали одинаковое количество очков");
            return true;
        }
        if (playersScores[1] == playersScores[2] && playersScores[1] > playersScores[0]) {
            System.out.println("Ничья, " + players[1].getName() + " и " +
                    players[2].getName() + " набрали одинаковое количество очков");
            return true;
        }
        if (playersScores[0] == playersScores[1] && playersScores[0] == playersScores[2]) {
            System.out.println("Ничья, все игроки набрали одинаковое количество очков");
            return true;
        }
        return false;
    }
}