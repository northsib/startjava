package com.startjava.lession2_3_4.calculator;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] mathOperators = {"+", "-", "/", "*", "%", "^"};
        String expression = "2222 %%5";
        expression = expression.replaceAll("\\s+", "");
        for (String operator : mathOperators) {
            if (expression.contains(operator + operator)) {
                System.out.println("Ошибка: выражение не поддерживается (введено " + operator + operator + ")");
            }
        }
        String[] numbers = expression.split(Arrays.toString(mathOperators));
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
        int mathOperatorsCount = 0;
        for (String string : temp) {
            for (String mathOperator : mathOperators) {
                if (string.equals(mathOperator)) {
                    mathOperatorsCount++;
                }
            }
        }
        System.out.println(mathOperatorsCount);
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