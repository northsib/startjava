package com.startjava.lession2_3_4.array;

import java.util.Arrays;

public class Console {
    private Console() {

    }

    public static void displayHeader(String title) {
        System.out.println("\n--- " + title + " ---\n");
    }

    public static void print(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public static void displayError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public static void printReversed(int[] numbers, int[] reversed) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        System.out.println("   До реверса: " + Arrays.toString(numbers));
        System.out.println("После реверса: " + Arrays.toString(reversed) + "\n");
    }

    public static void printFactorial(int[] original, long[] factorials) {
        if (original == null || original.length == 0) {
            return;
        }
        StringBuilder factorialExpression = new StringBuilder();
        for (int i = 0; i < original.length; i++) {
            if (factorials[i] == 1) {
                System.out.println(original[i] + "! = 1");
                continue;
            }
            if (factorials[i] == 0) {
                displayError("факториал " + original[i] + "! не определен");
                continue;
            }
            factorialExpression.append(original[i]).append("! = ");
            for (int j = 1; j <= original[i]; j++) {
                factorialExpression.append(j > 1 ? " * " + j : j);
            }
            System.out.println(factorialExpression.append(" = ").append(factorials[i]));
            factorialExpression.setLength(0);
        }
        System.out.println();
    }
}
