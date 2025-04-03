package com.startjava.lession2_3_4.calculator;

import java.util.Arrays;

public class Calculator {
    private static final String[] MATH_OPERATORS = {"+", "-", "/", "*", "%", "^"};
    private static final int ARGUMENTS_COUNT = 3;

    private Calculator() {}

    public static double calculate(String[] correctExpression) {
        if (!isValidExpression(correctExpression)) {
            return Double.NaN;
        } else {
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
                            displayError("На ноль делить нельзя!");
                            yield Double.NaN;
                        }
                        yield (double) firstNumber / secondNumber;
                    }
                    case '^' -> Math.pow(firstNumber, secondNumber);
                    case '%' -> (double) Math.floorMod(firstNumber, secondNumber);
                    default -> Double.NaN;
                };
            } catch (NumberFormatException e) {
                if (correctExpression[0].isEmpty()) {
                    displayError("Не введено первое число");
                    return Double.NaN;
                }
                displayError("Некорректно введено одно из чисел " + "(введено: \"" +
                        correctExpression[0] + "\" " +
                        "\"" + correctExpression[2] + "\")\nДопустимо: целые положительные, " +
                        "отрицательные числа, либо 0 (в диапазоне значений int)");
                return Double.NaN;
            }
        }
    }

    private static boolean isValidExpression(String[] splits) {
        return splits != null && splits.length != 0;
    }

    public static String[] makeCorrectExpression(String expression) {
        String[] splits = splitExpression(expression);
        if (!isValidExpression(splits)) {
            displayError("Введено пустое выражение");
            return null;
        }
        String[] correctExpression = new String[ARGUMENTS_COUNT];
        int[] mathOperatorIndexes = parseMathOperatorIndex(splits);
        if (mathOperatorIndexes == null) {
            displayError("Не введены мат операторы");
            return null;
        }

        correctExpression[0] = parseFirstNumber(splits, mathOperatorIndexes[0]);
        correctExpression[1] = splits[mathOperatorIndexes[0]];
        correctExpression[2] = parseSecondNumber(splits, mathOperatorIndexes);
        if (mathOperatorIndexes[1] != -1) {
            displayError("Некорректная длина выражения (допустимо: выражение из 3 аргументов например 2 + 1");
            return null;
        }
        if (correctExpression[2] == null) {
            if (mathOperatorIndexes[1] == -1) {
                displayError("Не введено второе число");
                return null;
            }
            displayError("Некорректный ввод мат операторов, введено: \"" + splits[mathOperatorIndexes[0]] +
                    splits[mathOperatorIndexes[1]] + "\", допустимо: \"" +
                    splits[mathOperatorIndexes[0]] + "\"");
            return null;
        }
        return correctExpression;
    }

    private static String[] splitExpression(String expression) {
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

    private static int[] parseMathOperatorIndex(String[] splits) {
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < splits.length; i++) {
            for (String mathOperator : MATH_OPERATORS) {
                if (splits[i].equals(mathOperator)) {
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

    private static String parseFirstNumber(String[] splits, int index) {
        StringBuilder firstNumberString = new StringBuilder();
        for (int i = 0; i < index; i++) {
            firstNumberString.append(splits[i]);
        }
        return firstNumberString.toString();
    }

    private static String parseSecondNumber(String[] splits, int[] indexes) {
        int start = indexes[0];
        int end = indexes[1] != -1 ? indexes[1] : splits.length;
        StringBuilder secondNumberString = new StringBuilder();
        if (start + 1 == end) {
            return null;
        }
        for (int i = start + 1; i < end; i++) {
            secondNumberString.append(splits[i]);
        }
        return secondNumberString.toString();
    }

//    private static boolean isCorrectExpressionLength(String[] splits, int[] indexes) {
//        if (indexes[1] != -1) {
//            String[] splitsOthers = new String[splits.length - indexes[1]];
//
//        }
//
//
//    }

    private static void displayError(String message) {
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
        System.out.println(expression[0] + " " + expression[1] + " " + expression[2] +
                " = " + resultString);
    }
}