package com.startjava.lession2_3_4.guess;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final int PLAYERS_COUNT = 3;
    private final int[] playerNumberSequence = new int[PLAYERS_COUNT];
    private int player1number = 1;
    private int player2number = 2;
    private int player3number = 3;
    private int currentPlayerIndex = 0;

    private int guessNumber;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player currentPlayer;
    private Scanner scanner;

    public GuessNumber(Player[] players) {
        this.player1 = players[0];
        this.player2 = players[1];
        this.player3 = players[2];
        this.guessNumber = (int) (Math.random() * 100) + 1;
        this.currentPlayer = player1;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        castLots();
        while (currentPlayer.getRemainingAttempts() >= 0) {
            System.out.print("Попытка " + currentPlayer.getCurrentAttempt() +
                    "\nЧисло вводит " + currentPlayer.getName() + ": ");
            int inputNumber = inputNumber();
            if (checkGuess(inputNumber)) {
                printWinGameMessage();
                break;
            }
            switchPlayer();
        }
        if (currentPlayer.getRemainingAttempts() < 0) {
            printLoseGameMessage();
        }
    }

    private void printPlayerGuessedNumbers() {
        int[] guessedNumbers = currentPlayer.getAttempts();
        System.out.println("Числа названные " + currentPlayer.getName() + ": ");

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

    private void printLoseGameMessage() {
        System.out.println("Игра окончена! Никто не выиграл");
        printAllPlayersNumbers();
    }

    private void printWinGameMessage() {
        System.out.println("Поздравляем! Игрок " + currentPlayer.getName() +
                " отгадал загаданное число - " + guessNumber +
                " c " + currentPlayer.getCurrentAttempt() + "-й попытки");
        currentPlayer.attemptIncrease();
        printAllPlayersNumbers();
    }

    private void printAllPlayersNumbers() {
        printPlayerGuessedNumbers();
        switchPlayer();
        printPlayerGuessedNumbers();
        switchPlayer();
        printPlayerGuessedNumbers();
    }

    private int inputNumber() {
        while (true) {
            try {
                int inputNumber = scanner.nextInt();
                return currentPlayer.setNumber(inputNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage() + "\nПопробуйте еще раз: ");
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: некорректный ввод числа\nПопробуйте еще раз: ");
                scanner.nextLine();
            }
        }
    }

    private boolean checkGuess(int inputNumber) {
        if (currentPlayer.hasAttemptsLeft(inputNumber)) {
            if (inputNumber == guessNumber) {
                return true;
            }
            System.out.println(inputNumber + (inputNumber > guessNumber ? " больше, чем загаданное число" :
                    " меньше, чем загаданное число"));
        }
        currentPlayer.attemptIncrease();
        return false;
    }

    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % PLAYERS_COUNT;
        int nextPlayerIndex = playerNumberSequence[currentPlayerIndex];

        if (nextPlayerIndex == player1number) {
            currentPlayer = player1;
        }
        if (nextPlayerIndex == player2number) {
            currentPlayer = player2;
        }
        if (nextPlayerIndex == player3number) {
            currentPlayer = player3;
        }
    }

    private void castLots() {
        Random random = new Random();
        System.out.println("Жребий ! ! !");
        for (int i = 0; i < PLAYERS_COUNT; i++) {
            playerNumberSequence[i] = i + 1;
        }

        for (int i = playerNumberSequence.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            if (i != j) {
                int temp = playerNumberSequence[i];
                playerNumberSequence[i] = playerNumberSequence[j];
                playerNumberSequence[j] = temp;
            }
        }
        if (playerNumberSequence[0] == player1number) {
            System.out.println("Жребий выиграл " + player1.getName());
            currentPlayer = player1;
        }
        if (playerNumberSequence[0] == player2number) {
            System.out.println("Жребий выиграл " + player2.getName());
            currentPlayer = player2;
        }
        if (playerNumberSequence[0] == player3number) {
            System.out.println("Жребий выиграл " + player3.getName());
            currentPlayer = player3;
        }
    }
}