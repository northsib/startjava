package com.startjava.lession2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        long[] factorials = calculate();
        int[] original = {};
        print(original, factorials);

        factorials = calculate(null);
        original = null;
        print(original, factorials);

        factorials = calculate(8, 0, 9);
        original = new int[]{8, 0, 9};
        print(original, factorials);

        factorials = calculate(-3, 1, 7, 13);
        original = new int[]{-3, 1, 7, 13};
        print(original, factorials);

        factorials = calculate(-22, -0);
        original = new int[]{-22, -0};
        print(original, factorials);
    }

    private static long[] calculate(int... numbers) {
        if (numbers == null) {
            return null;
        }
        if (numbers.length == 0) {
            return null;
        }
        long[] factorials = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                factorials[i] = 0;
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
            StringBuilder outputExpression = new StringBuilder();
            System.out.println(outputExpression.append(original[i])
                    .append("! = ").append(factorialExpression)
                    .append(" = ").append(factorials[i]));
        }
        System.out.println();
    }
}