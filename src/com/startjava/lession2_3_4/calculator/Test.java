package com.startjava.lession2_3_4.calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    static String[] mathOperators = {"+", "-", "/", "*", "%", "^"};
    static Integer firstNumber = 0;
    static Integer secondNumber = 0;
    static Character mathOperator = '%';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение из 3 аргументов (например: 2 + 1)");
        String expression = scanner.nextLine();
        String[] values = splitExpression(expression);
        System.out.println(Arrays.toString(values));
        int mathOperatorIndex = parseMathOperatorIndex(values);
        System.out.println(values[mathOperatorIndex]);
        System.out.println(mathOperatorIndex);
        makeExpression(values, mathOperatorIndex);
        System.out.println(firstNumber + " " + secondNumber + " " + mathOperator);
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

    public static int parseMathOperatorIndex(String[] values) {
        int index = 0;
        for (int i = 0; i < values.length; i++) {
            for (String mathOperator : mathOperators) {
                if (values[i].equals(mathOperator)) {
                    index = i;
                    break;
                }
                break;
            }
        }
        return index;
    }

    public static void makeExpression(String[] values, int index) {
        StringBuilder firstNumberString = new StringBuilder();
        for (int i = 0; i < index; i++) {
            firstNumberString.append(values[i]);
        }
        firstNumber = Integer.parseInt(firstNumberString.toString());
        StringBuilder secondNumberString = new StringBuilder();
        for (int i = index + 1; i < values.length; i++) {
            secondNumberString.append(values[i]);
        }
        secondNumber = Integer.parseInt(secondNumberString.toString());
        mathOperator = values[index].charAt(0);
    }
}

