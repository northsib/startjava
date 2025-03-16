package com.startjava.lession2_3_4.array;

public class ArrayUniqueFiller {
    public static void main(String[] args) {
        int start = -30;
        int end = -10;
        int numbersPerLine = 23;
        int[] unique = create(start, end, numbersPerLine);
        print(unique, numbersPerLine);

        start = 10;
        end = 50;
        numbersPerLine = 10;
        unique = create(start, end, numbersPerLine);
        print(unique, numbersPerLine);

        start = -34;
        end = -34;
        numbersPerLine = 0;
        unique = create(start, end, numbersPerLine);
        print(unique, numbersPerLine);

        start = -1;
        end = 2;
        numbersPerLine = -3;
        unique = create(start, end, numbersPerLine);
        print(unique, numbersPerLine);

        start = 5;
        end = -8;
        numbersPerLine = 2;
        unique = create(start, end, numbersPerLine);
        print(unique, numbersPerLine);
    }

    private static int[] create(int start, int end, int numbersPerLine) {
        if (numbersPerLine < 1) {
            System.out.println("\nОшибка: количество чисел в строке не должно быть < 1 (" +
                    numbersPerLine + ")");
            return null;
        }
        if (start > end) {
            System.out.println("\nОшибка: левая граница (" + start + ") > правой (" + end + ")\n");
            return null;
        }
        int arraySize = (int) (0.75 * (end - start + 1));
        if (arraySize <= 0) {
            System.out.println("\nОшибка: длина массива должна быть > 0 (" + arraySize + ")\n");
            return null;
        }
        int[] uniqueNumbers = new int[arraySize];
        int[] usedNumbers = new int[end - start + 1];
        int numbersCounter = 0;

        while (numbersCounter < arraySize) {
            int randomNumber = start > 0 ? (int) (Math.random() * (end - start + 1) + start) :
                    (int) (Math.random() * (end - start + 1) + start - 1);
            int index = randomNumber - start;
            if (usedNumbers[index] == 0) {
                uniqueNumbers[numbersCounter] = randomNumber;
                usedNumbers[index] = 1;
                numbersCounter++;
            }
        }

        for (int i = 1; i < arraySize; i++) {
            int currentNumber = uniqueNumbers[i];
            int j = i - 1;
            while (j >= 0 && currentNumber < uniqueNumbers[j]) {
                uniqueNumbers[j + 1] = uniqueNumbers[j];
                j--;
            }
            uniqueNumbers[j + 1] = currentNumber;
        }
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