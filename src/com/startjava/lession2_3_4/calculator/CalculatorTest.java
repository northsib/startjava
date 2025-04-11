package com.startjava.lession2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        String userChoose = "yes";

        while (userChoose.equals("yes")) {
            System.out.println("Введите выражение из 3 аргументов," +
                    "отделяя каждый аргумент пробелом (например: 2 + 1)");
            String expression = formatExpression(scanner.nextLine());
            double result = Calculator.calculate(expression);
            printResult(expression, result);
            System.out.println("Хотите продолжить вычисления? [yes/no]:");
            userChoose = scanner.nextLine().toLowerCase();
            while (!userChoose.equals("yes") && !userChoose.equals("no")) {
                System.out.println("Введите корректный ответ [yes/no]:");
                userChoose = scanner.nextLine().toLowerCase();
            }
        }
        scanner.close();
    }

    private static String formatExpression(String expression) {
        expression = expression.replaceAll("\\s+", " ").trim();
        return expression;
    }

    private static void printResult(String expression, double result) {
        if (Double.isNaN(result)) {
            return;
        }
        String resultString;
        if (result == (int) result) {
            resultString = String.valueOf((int) result);
        } else {
            String formattedResult = String.format("%.3f", result);
            resultString = formattedResult.replaceAll("0+$", "");
        }
        System.out.println(expression + " = " + resultString);
    }
}
