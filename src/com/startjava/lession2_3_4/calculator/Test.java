package com.startjava.lession2_3_4.calculator;

import java.util.Arrays;

public class Test {
    private static final String[] MATH_OPERATORS = {"+", "-", "/", "*", "%", "^"};

    public static void main(String[] args) throws InvalidInputExceprion {
        String expression = "22.22 + 5";
        checkExpression(expression);
        expression = expression.replaceAll("\\s+", "");
        for (String operator : MATH_OPERATORS) {
            if (expression.contains(operator + operator)) {
                System.out.println("Ошибка: выражение не поддерживается (введено " + operator + operator + ")");
            }
        }
        String[] numbers = expression.split(Arrays.toString(MATH_OPERATORS));
        int numbersCount = 0;
        for (String number : numbers) {
            if (number.isBlank()) {
                continue;
            }
            numbers[numbersCount] = number;
            numbersCount++;
        }
        String[] correctNumbers = Arrays.copyOf(numbers, numbersCount);
        System.out.println(Arrays.toString(correctNumbers));
        String[] temp = expression.split("");
        int MATH_OPERATORSCount = 0;
        for (String string : temp) {
            for (String mathOperator : MATH_OPERATORS) {
                if (string.equals(mathOperator)) {
                    MATH_OPERATORSCount++;
                }
            }
        }
        System.out.println(MATH_OPERATORSCount);
    }

    private static void checkExpression(String expression) throws InvalidInputExceprion {
        expression = expression.replaceAll("\\s+", "");
        if (expression.isEmpty()) {
            throw new InvalidInputExceprion("Введено пустое выражение");
        }
        int mathOperatorCount = getMathOperatorCount(expression);

        String[] tempNumbers = expression.split(Arrays.toString(MATH_OPERATORS));
        int numbersCount = 0;
        for (String number : tempNumbers) {
            if (number.isBlank()) {
                continue;
            }
            tempNumbers[numbersCount] = number;
            numbersCount++;
        }
        String[] numbers = Arrays.copyOf(tempNumbers, numbersCount);

        if (mathOperatorCount > 1 || numbers.length > 2) {
            throw new InvalidInputExceprion("Неверная длина выражения " +
                    "(допустимо: выражение из 3 аргументов, например 2 + 1)");
        }

        for (String number : numbers) {
            if (!isValidNumber(number)) {
                throw new InvalidInputExceprion("Вводимые вами числа должны быть " +
                        "целыми (введено: " + number + ")");
            }
        }
    }

    private static int getMathOperatorCount(String expression) throws InvalidInputExceprion {
        for (String operator : MATH_OPERATORS) {
            if (expression.contains(operator + operator + operator)) {
                throw new InvalidInputExceprion("Некорректно введен знак математического оператора " +
                        "(введено: " + operator +
                        operator + operator +
                        " допустимо: " + operator + ")");
            }
            if (expression.contains(operator + operator)) {
                throw new InvalidInputExceprion("Некорректно введен знак математического оператора " +
                        "(введено: " + operator +
                        operator + " допустимо: " +
                        operator + ")");
            }
        }

        String[] splits = expression.split("");
        int mathOperatorCount = 0;
        for (String split : splits) {
            for (String mathOperator : MATH_OPERATORS) {
                if (split.equals(mathOperator)) {
                    mathOperatorCount++;
                }
            }
        }
        return mathOperatorCount;
    }

    private static boolean isValidNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
//public static double calculate(String[] correctExpression) {
//    if (!isValidExpression(correctExpression)) {
//        return Double.NaN;
//    } else {
//        try {
//            int firstNumber = Integer.parseInt(correctExpression[0]);
//            int secondNumber = Integer.parseInt(correctExpression[2]);
//            char mathOperator = correctExpression[1].charAt(0);
//            return switch (mathOperator) {
//                case '+' -> firstNumber + secondNumber;
//                case '-' -> firstNumber - secondNumber;
//                case '*' -> firstNumber * secondNumber;
//                case '/' -> {
//                    if (secondNumber == 0) {
//                        displayError("На ноль делить нельзя!");
//                        yield Double.NaN;
//                    }
//                    yield (double) firstNumber / secondNumber;
//                }
//                case '^' -> Math.pow(firstNumber, secondNumber);
//                case '%' -> (double) Math.floorMod(firstNumber, secondNumber);
//                default -> Double.NaN;
//            };
//        } catch (NumberFormatException e) {
//            if (correctExpression[0].isEmpty()) {
//                displayError("Не введено первое число");
//                return Double.NaN;
//            }
//            displayError("Некорректно введено одно из чисел " + "(введено: \"" +
//                    correctExpression[0] + "\" " +
//                    "\"" + correctExpression[2] + "\")\nДопустимо: целые положительные, " +
//                    "отрицательные числа, либо 0 (в диапазоне значений int)");
//            return Double.NaN;
//        }
//    }
//}