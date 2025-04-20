package com.startjava.lession2_3_4.guess;

import java.util.Arrays;

public class Player {
    public static final int ATTEMPTS_COUNT = 10;
    private int[] attempts = new int[ATTEMPTS_COUNT];
    private int currentAttempt = 1;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentAttempt() {
        return currentAttempt;
    }

    public int setNumber(int number) {
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException("Введенное число должно быть от 1 до 100");
        }
        return number;
    }

    public int[] getAttempts() {
        return Arrays.copyOf(attempts, currentAttempt - 1);
    }

    public boolean hasAttemptsLeft(int number) {
        if (currentAttempt == ATTEMPTS_COUNT) {
            System.out.println("Попытки у " + name + " закончились!");
        }
        attempts[currentAttempt - 1] = number;
        return true;
    }

    public int getRemainingAttempts() {
        return ATTEMPTS_COUNT - currentAttempt;
    }

    public void attemptIncrease() {
        currentAttempt++;
    }
}