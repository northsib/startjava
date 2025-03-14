package com.startjava.lession2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        calculateFactorial();
        calculateFactorial(null);
        calculateFactorial(8, 0, 9);
        calculateFactorial(-3, 1, 7, 13);
        calculateFactorial(-22, -0);
    }

    private static void calculateFactorial (long... numbers) {
        if (numbers == null) {
            System.out.println("null\n");
            return;
        }
        if (numbers.length == 0) {
            System.out.println("Массив нулевой длины\n");
            return;
        }

        long[] factorials = new long[numbers.length];
        String[] factorialExpression = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                factorials[i] = -1;
                continue;
            }
            long factorial = 1;
            String expression = "";
            for (int j = 1; j <= numbers[i]; j++) {
                factorial *= j;
                expression += (j > 1 ? " * " : "") + j;
            }
            factorials[i] = factorial;
            factorialExpression[i] = expression;
        }

        for (int i = 0; i < factorials.length; i++) {
            if (factorials[i] == 1) {
                System.out.printf(numbers[i] + "! = 1\n");
            } else {
                System.out.println((factorials[i] == -1 ?
                        "Ошибка: факториал " + numbers[i] + "! не определен" :
                        numbers[i] + "! = " + factorialExpression[i] + " = " + factorials[i]));
            }
        }
        System.out.println();
    }
}