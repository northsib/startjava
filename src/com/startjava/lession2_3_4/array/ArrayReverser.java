package com.startjava.lession2_3_4.array;

import java.util.Scanner;

public class ArrayReverser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину массива: ");
        int arrayLength = scanner.nextInt();
        int[] numbers = createArray(scanner, arrayLength);
        if (isCorrectArray(numbers)) {
            printArray(numbers);
            reverseArray(numbers);
        }
    }

    public static int[] createArray(Scanner scanner, int arrayLength) {
        if (arrayLength == 0) {
            System.out.println("Массив нулевой длины");
            return null;
        }
        int[] numbers = new int[arrayLength];
        System.out.print("заполните массив целыми числами через пробел: ");
        for (int i = 0; i < arrayLength; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    public static boolean isCorrectArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("null");
            return false;
        }
        return true;
    }

    public static void printArray(int[] numbers) {
        System.out.printf("%16s", "До реверса: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < (numbers.length - 1)) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void reverseArray(int[] numbers) {
        System.out.print("После реверса: [");
        for (int i = (numbers.length - 1); i >= 0; i--) {
            System.out.print(numbers[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
