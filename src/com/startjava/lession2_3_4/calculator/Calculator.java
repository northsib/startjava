package com.startjava.lession2_3_4.calculator;

public class Calculator {
    private static final int ARGS_COUNT = 3;

    private Calculator() {
    }

    public static double calculate(String expression) {
        try {
            String[] parts = checkAndSplit(expression);
            int firstNumber = Integer.parseInt(parts[0]);
            int secondNumber = Integer.parseInt(parts[2]);
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
                case "%" -> (double) Math.floorMod(firstNumber, secondNumber);
                default -> throw new IllegalStateException("Некорректный ввод математического оператора" +
                        " (введено: " + parts[1] + ", допустимо: +, -, *, /, %, ^)");
            };
        } catch (InvalidInputException | ArithmeticException | IllegalStateException e) {
            displayError(e.getMessage());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            displayError("Недопустимый ввод чисел (допустимо: " +
                    "целые положительные и отрицательные числа или 0)");
        }
        return Double.NaN;
    }

    private static String[] checkAndSplit(String expression) throws InvalidInputException {
        if (expression == null || expression.isEmpty()) {
            throw new InvalidInputException("Введено пустое выражение");
        }
        String[] parts = expression.split(" ");
        if (parts.length > ARGS_COUNT) {
            throw new InvalidInputException("Недопустимая длина выражения (допустимо: выражение " +
                    "из 3 аргументов, например: 2 + 1, или -2 + -1)");
        }
        return parts;
    }

    private static void displayError(String message) {
        System.out.println("Ошибка: " + message);
    }
}

