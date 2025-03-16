package com.startjava.lession2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        int[] emptyOriginal = {};
        long[] factorials = calculate(emptyOriginal);
        print(emptyOriginal, factorials);

        int[] nullOriginal = null;
        factorials = calculate(nullOriginal);
        print(nullOriginal, factorials);

        int[] original3 = {8, 0, 9};
        factorials = calculate(original3);
        print(original3, factorials);

        int[] original4 = {-3, 1, 7, 13};
        factorials = calculate(original4);
        print(original4, factorials);

        int[] original2 = {-22, -0};
        factorials = calculate(original2);
        print(original2, factorials);
    }

    private static long[] calculate(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        long[] factorials = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                continue;
            }
            long factorial = 1;
            for (int j = 2; j <= numbers[i]; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    private static void print(int[] original, long[] factorials) {
        if (original == null) {
            System.out.println("null\n");
            return;
        }
        if (original.length == 0) {
            System.out.println("Массив нулевой длины\n");
            return;
        }

        for (int i = 0; i < original.length; i++) {
            if (factorials[i] == 1) {
                System.out.println(original[i] + "! = 1");
                continue;
            }
            if (factorials[i] == 0) {
                System.out.println("Ошибка: факториал " + original[i] + "! не определен");
                continue;
            }
            StringBuilder factorialExpression = new StringBuilder();
            for (int j = 1; j <= original[i]; j++) {
                factorialExpression.append(j > 1 ? " * " + j : j);
            }
            System.out.println(original[i] + "! = " + factorialExpression + " = " + factorials[i]);
        }
        System.out.println();
    }
}