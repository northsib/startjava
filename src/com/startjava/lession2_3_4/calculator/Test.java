package com.startjava.lession2_3_4.calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    static String[] mathOperators = {"+", "-", "/", "*", "%", "^"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение из 3 аргументов (например: 2 + 1)");
        String expression = scanner.nextLine();
        String[] values = splitExpression(expression);
        System.out.println(Arrays.toString(values));
        String[] correctExpression = makeCorrectExpression(values);
        System.out.println(Arrays.toString(correctExpression));
        double result = calculate(correctExpression);
        printResult(correctExpression, result);
    }

    public static String[] splitExpression(String expression) {
        String[] temp = expression.split("");
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].isBlank()) {
                continue;
            }
            temp[index] = temp[i];
            index++;
        }
        return Arrays.copyOf(temp, index);
    }

    public static String[] makeCorrectExpression(String[] values) {
        if (values == null || values.length == 0) {
            displayError("Введено пустое выражение");
            return null;
        }
        String[] expression = new String[3];
        int[] mathOperatorIndexes = parseMathOperatorIndex(values);
        if (mathOperatorIndexes == null) {
            displayError("Не введены мат операторы");
            return null;
        }
        expression[0] = parseFirstNumber(values, mathOperatorIndexes[0]);
        expression[1] = values[mathOperatorIndexes[0]];
        expression[2] = parseSecondNumber(values, mathOperatorIndexes);
        if (expression[2] == null) {
            return null;
        }
        return expression;
    }

    public static int[] parseMathOperatorIndex(String[] values) {
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < values.length; i++) {
            for (String mathOperator : mathOperators) {
                if (values[i].equals(mathOperator)) {
                    if (index1 == -1) {
                        index1 = i;
                    } else if (index2 == -1 && i != index1) {
                        index2 = i;
                        break;
                    }
                }
            }
        }
        if (index1 == -1 && index2 == -1) {
            return null;
        }
        return new int[]{index1, index2};
    }

    public static String parseFirstNumber(String[] values, int index) {
        StringBuilder firstNumberString = new StringBuilder();
        for (int i = 0; i < index; i++) {
            firstNumberString.append(values[i]);
        }
        return firstNumberString.toString();
    }

    public static String parseSecondNumber(String[] values, int[] indexes) {
        int start = indexes[0];
        int end = indexes[1] != -1 ? indexes[1] : values.length;
        StringBuilder secondNumberString = new StringBuilder();
        if (start + 1 == end) {
            displayError("Некорректный ввод мат операторов, введено: " + values[start] +
                    values[end] + ", допустимо: " + values[start]);
            return null;
        }
        for (int i = start + 1; i < end; i++) {
            secondNumberString.append(values[i]);
        }
        return secondNumberString.toString();
    }

    public static double calculate(String[] correctExpression) {
        if (correctExpression == null || correctExpression.length != 3) {
            return Double.NaN;
        }
        try {
            int firstNumber = Integer.parseInt(correctExpression[0]);
            int secondNumber = Integer.parseInt(correctExpression[2]);
            char mathOperator = correctExpression[1].charAt(0);
            return switch (mathOperator) {
                case '+' -> firstNumber + secondNumber;
                case '-' -> firstNumber - secondNumber;
                case '*' -> firstNumber * secondNumber;
                case '/' -> {
                    if (secondNumber == 0) {
                        displayError("на ноль делить нельзя!");
                        yield Double.NaN;
                    }
                    yield (double) firstNumber / secondNumber;
                }
                case '^' -> Math.pow(firstNumber, secondNumber);
                case '%' -> (double) Math.floorMod(firstNumber, secondNumber);
                default -> {
                    displayError("некорректный ввод оператора (введено: " + mathOperator + ")");
                    yield Double.NaN;
                }
            };
        } catch (NumberFormatException e) {
            displayError("Некорректно введено одно из чисел " +
                    "(допустимо: целые положительные, " +
                    "отрицательные числа, либо 0)");
            return Double.NaN;
        }
    }

    public static void displayError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public static void printResult(String[] expression, double result) {
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
        System.out.println("Вы ввели выражение: " + expression[0] + " " + expression[1] + " " + expression[2] +
                "\nОтвет: " + resultString);
    }
}


