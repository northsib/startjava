package com.startjava.lession2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        print(calculate());
        print(calculate(null), null);
        print(calculate(8, 0, 9), 8, 0, 9);
        print(calculate(-3, 1, 7, 13), -3, 1, 7, 13);
        print(calculate(-22, -0), -22, -0);
    }

    private static long[] calculate(long... numbers) {
        if (numbers == null) {
            return null;
        }
        if (numbers.length == 0) {
            return numbers;
        }
        long[] factorials = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                factorials[i] = -1000;
                continue;
            }
            long factorial = 1;
            for (int j = 1; j <= numbers[i]; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    private static void print(long[] factorials, int... numbers) {
        if (numbers == null) {
            System.out.println("null\n");
            return;
        }
        if (numbers.length == 0) {
            System.out.println("Массив нулевой длины\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (factorials[i] == 1) {
                System.out.println(numbers[i] + "! = 1");
                continue;
            }
            if (factorials[i] == -1000) {
                System.out.println("Ошибка: факториал " + numbers[i] + "! не определен");
                continue;
            }
            StringBuilder factorialExpression = new StringBuilder();
            for (int j = 1; j <= numbers[i]; j++) {
                factorialExpression.append(j > 1 ? " * " + j : j);
            }
            System.out.println(numbers[i] + "! = " + factorialExpression + " = " + factorials[i]);
        }
        System.out.println();
    }
}