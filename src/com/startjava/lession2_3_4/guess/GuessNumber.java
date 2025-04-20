package com.startjava.lession2_3_4.guess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumber {
    private int guessNumber;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public GuessNumber(Player[] players) {
        this.player1 = players[0];
        this.player2 = players[1];
        this.guessNumber = (int) (Math.random() * 100) + 1;
        this.currentPlayer = player1;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
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
            if (i == Player.ATTEMPTS_COUNT / 2) {
                System.out.println();
            }
            System.out.print(guessedNumbers[i] + " ");
        }
        System.out.println();
    }

    private void printLoseGameMessage() {
        System.out.println("Игра окончена! Никто не выиграл");
        printBothPlayersNumbers();
    }

    private void printWinGameMessage() {
        System.out.println("Поздравляем! Игрок " + currentPlayer.getName() +
                " отгадал загаданное число - " + guessNumber +
                " c " + currentPlayer.getCurrentAttempt() + "-й попытки");
        currentPlayer.attemptIncrease();
        printBothPlayersNumbers();
    }

    private void printBothPlayersNumbers() {
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
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}