package com.startjava.lession2_3_4.calculator;

public class Calculator {
    private static final int ARGS_COUNT = 3;

    private Calculator() {
    }

    public static double calculate(String expression) {
        checkExpression(expression);
        String[] parts = splitExpression(expression);
        int firstNumber = getInteger(parts[0]);
        int secondNumber = getInteger(parts[2]);
        String mathOperator = parts[1];
        return switch (mathOperator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> {
                if (secondNumber == 0) {
                    throw new ArithmeticException("Деление на 0 невозможно");
                }
                yield (double) firstNumber / secondNumber;
            }
            case "^" -> Math.pow(firstNumber, secondNumber);
            case "%" -> {
                if (secondNumber == 0) {
                    throw new ArithmeticException("Деление на 0 невозможно");
                }
                yield (double) Math.floorMod(firstNumber, secondNumber);
            }
            default -> throw new UnsupportedOperationException("Некорректный ввод математического оператора" +
                    " (введено: " + parts[1] + ", допустимо: +, -, *, /, %, ^)");
        };
    }

    private static void checkExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new InvalidInputException("Введено пустое выражение");
        }
    }

    private static String[] splitExpression(String expression) {
        String[] parts = expression.split(" ");
        if (parts.length > ARGS_COUNT) {
            throw new InvalidExpressionLengthException("Недопустимая длина выражения (допустимо: выражение " +
                    "из 3 аргументов, например: 2 + 1, или -2 + -1)");
        }
        return parts;
    }

    private static int getInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Недопустимый ввод чисел (введено: " +
                    number + ", допустимо: целые числа, например: " +
                    "1, -22, 333 и так далее,\nчисла и " +
                    "операторы необходимо отделить пробелом)");
        }
    }
}