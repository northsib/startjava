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
            System.out.println("null");
            return;
        }
        if (numbers.length == 0) {
            System.out.println("Массив нулевой длины");
            return;
        }

        long[] factorials = new long[numbers.length];
//        String[] factorialExpression = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                factorials[i] = -1;
                continue;
            }
            long factorial = 1;
            for (int j = 1; j <= numbers[i]; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }

        for (int i = 0; i < factorials.length; i++) {
            if (factorials[i] == -1) {
                System.out.print("Ошибка: факториал " + numbers[i] + "! не определен");
                if (i < (factorials.length - 1)) {
                    System.out.print(", ");
                }
                continue;
            }
            System.out.print(factorials[i]);
            if (i < (factorials.length - 1)) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

/*
private static void calculateFactorial(long... numbers) {
    if (numbers == null) {
        System.out.println("null");
        return;
    }
    if (numbers.length == 0) {
        System.out.println("Массив нулевой длины");
        return;
    }

    long[] factorials = new long[numbers.length];
    String[] expressions = new String[numbers.length];

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
        expressions[i] = expression;
    }

    for (int i = 0; i < factorials.length; i++) {
        System.out.print((factorials[i] == -1 ?
            "Ошибка: факториал " + numbers[i] + "! не определен" :
            numbers[i] + "! = " + expressions[i] + " = " + factorials[i]));

        if (i < factorials.length - 1) {
            System.out.print(", ");
        }
    }
    System.out.println();
 */
