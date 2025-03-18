package com.startjava.lession2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueFiller {
    public static void main(String[] args) {
        int numbersPerLine = 23;
        int[] unique = fill(-30, -10, numbersPerLine);
        print(unique, numbersPerLine);

        unique = fill(10, 50, numbersPerLine = 10);
        print(unique, numbersPerLine);

        unique = fill(-34, -34, numbersPerLine = 0);
        print(unique, numbersPerLine);

        unique = fill(-1, 2, numbersPerLine = -3);
        print(unique, numbersPerLine);

        unique = fill(5, -8, numbersPerLine = 2);
        print(unique, numbersPerLine);
    }

    private static int[] fill(int start, int end, int numbersPerLine) {
        if (numbersPerLine < 1) {
            System.out.println("\nОшибка: количество чисел в строке не должно быть < 1 (" +
                    numbersPerLine + ")");
            return null;
        }
        if (start > end) {
            System.out.println("\nОшибка: левая граница (" + start + ") > правой (" + end + ")\n");
            return null;
        }
        int length = (int) (0.75 * (end - start + 1));
        if (length <= 0) {
            System.out.println("\nОшибка: длина массива должна быть > 0 (" + length + ")\n");
            return null;
        }
        int[] uniqueNumbers = new int[length];
        int numbersCounter = 0;

        while (numbersCounter < length) {
            Random random = new Random();
            int randomNumber = random.nextInt(start, end + 1);
            boolean isUnique = true;
            for (int i = 0; i < numbersCounter; i++) {
                if (uniqueNumbers[i] == randomNumber) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueNumbers[numbersCounter] = randomNumber;
                numbersCounter++;
            }
        }
        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    private static void print(int[] numbers, int numbersPerLine) {
        if (numbers == null) {
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if ((i % numbersPerLine) == 0) {
                System.out.println();
            }
            System.out.printf("%3d%s", numbers[i], (i < numbers.length - 1) ? ", " : "");
        }
        System.out.println();
    }
}