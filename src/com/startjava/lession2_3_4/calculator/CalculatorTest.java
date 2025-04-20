package com.startjava.lession2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoose = "yes";

        while (!userChoose.equals("no")) {
            if (userChoose.equals("yes")) {
                try {
                    String expression = inputExpression(scanner);
                    double result = Calculator.calculate(expression);
                    printResult(expression, result);
                } catch (RuntimeException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
            }
            if (!userChoose.equals("yes")) {
                System.out.println("Введите корректный ответ [yes/no]:");
            }
            userChoose = scanner.nextLine().toLowerCase();
        }
        scanner.close();
    }

    private static String inputExpression(Scanner scanner) {
        System.out.println("Введите выражение из 3 аргументов," +
                "отделяя каждый аргумент пробелом (например: 2 + 1)");
        String expression = scanner.nextLine();
        return expression.trim().replaceAll("\\s+", " ");
    }

    private static void printResult(String expression, double result) {
        DecimalFormat formattedResult = new DecimalFormat("#.###");
        String resultString = formattedResult.format(result);
        System.out.println(expression + " = " + resultString);
    }
}
