package com.startjava.lession2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        String userChoose = "yes";

        while (userChoose.equals("yes")) {
            try {
                String expression = inputExpression(scanner);
                double result = Calculator.calculate(expression);
                printResult(expression, result);
            } catch (InvalidInputException | ArithmeticException |
                     IllegalStateException | InvalidExpressionLengthException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Недопустимый ввод чисел (допустимо: " +
                        "целые положительные и отрицательные числа или 0)");
            }

            System.out.println("Хотите продолжить вычисления? [yes/no]:");
            userChoose = scanner.nextLine().toLowerCase();
            if (!userChoose.equals("yes") && !userChoose.equals("no")) {
                userChoose = getCorrectAnswer(scanner);
            }
        }
        scanner.close();
    }

    private static String getCorrectAnswer(Scanner scanner) {
        String userChoose;
        do {
            System.out.println("Введите корректный ответ [yes/no]:");
            userChoose = scanner.nextLine().toLowerCase();
        } while (!userChoose.equals("yes") && !userChoose.equals("no"));
        return userChoose;
    }

    private static String inputExpression(Scanner scanner) {
        System.out.println("Введите выражение из 3 аргументов," +
                "отделяя каждый аргумент пробелом (например: 2 + 1)");
        return formatExpression(scanner.nextLine());
    }

    private static String formatExpression(String expression) {
        return expression.trim().replaceAll("\\s+", " ");
    }

    private static void printResult(String expression, double result) {
        DecimalFormat formattedResult = new DecimalFormat("#.###");
        String resultString;
        if (result == (int) result) {
            resultString = String.valueOf((int) result);
        } else {
            resultString = formattedResult.format(result);
            resultString = resultString.replaceAll("0+$", "");
        }
        System.out.println(expression + " = " + resultString);
    }
}
