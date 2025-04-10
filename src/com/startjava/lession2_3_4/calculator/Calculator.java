package com.startjava.lession2_3_4.calculator;

public class Calculator {
    private static final String[] MATH_OPERATORS = {"+", "-", "/", "*", "%", "^"};
    private static final int ARGUMENTS_COUNT = 3;

    private Calculator() {
    }

    public static double calculate(String expression) {
        try {
            checkInput(expression);
            expression = formatExpression(expression);
            String[] parts = splitParts(expression);
            int firstNumber = Integer.parseInt(parts[0]);
            int secondNumber = Integer.parseInt(parts[2]);
            char mathOperator = parts[1].charAt(0);
            return switch (mathOperator) {
                case '+' -> firstNumber + secondNumber;
                case '-' -> firstNumber - secondNumber;
                case '*' -> firstNumber * secondNumber;
                case '/' -> {
                    if (secondNumber == 0) {
                        throw new ArithmeticException("Деление на 0 невозможно");
                    }
                    yield (double) firstNumber / secondNumber;
                }
                case '^' -> Math.pow(firstNumber, secondNumber);
                case '%' -> (double) Math.floorMod(firstNumber, secondNumber);
                default -> throw new IllegalStateException("Некорректное значение: " + mathOperator);
            };
        } catch (InvalidInputException e) {
            displayError(e.getMessage());
        } catch (NumberFormatException e) {
            displayError("Некорректный ввод выражения " +
                    "(допустимо: выражение из 3 аргументов, например: 2 + 1)");
        } catch (ArrayIndexOutOfBoundsException e) {
            displayError("Не введено второе число");
        }
        return Double.NaN;
    }

    private static void checkInput(String expression) throws InvalidInputException {
        if (expression == null || expression.isEmpty()) {
            throw new InvalidInputException("Введено пустое выражение");
        }
        for (String operator : MATH_OPERATORS) {
            if (expression.contains(operator + operator)) {
                throw new InvalidInputException("Неверный знак математического выражения, введено: " +
                        operator + operator);
            }
        }
    }

    private static String formatExpression(String expression) {
        String noWhitespacesExpression = expression.replaceAll("\\s+", "");
        StringBuilder formatedExpression = new StringBuilder();
        for (int i = 0; i < noWhitespacesExpression.length(); i++) {
            char current = noWhitespacesExpression.charAt(i);
            formatedExpression.append(current);
            if (i < noWhitespacesExpression.length() - 1) {
                char next = noWhitespacesExpression.charAt(i + 1);
                if ((Character.isDigit(current) && !Character.isDigit(next)) ||
                        (!Character.isDigit(current) && Character.isDigit(next))) {
                    formatedExpression.append(" ");
                }
            }
        }
        return formatedExpression.toString();
    }

    private static String[] splitParts(String formatExpression) throws InvalidInputException {
        String[] expressionParts = formatExpression.split(" ");
        if (expressionParts.length > ARGUMENTS_COUNT) {
            throw new InvalidInputException("Недопустимая длина выражения (допустимо: выражение " +
                    "из 3 аргументов, например: 2 + 1)");
        }
        String[] operatorInCharArray = expressionParts[1].split("");
        if (operatorInCharArray.length > 1) {
            String secondPart = operatorInCharArray[1] + expressionParts[2];
            expressionParts[1] = operatorInCharArray[0];
            expressionParts[2] = secondPart;
        }
        return expressionParts;
    }

    public static void printResult(String expression, double result) {
        expression = formatExpression(expression);
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

    private static void displayError(String message) {
        System.out.println("Ошибка: " + message);
    }
}

