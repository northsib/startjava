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

        int[] mathOperatorsIndex = parseMathOperator(values);
        System.out.println(Arrays.toString(mathOperatorsIndex));
        System.out.println(values[mathOperatorsIndex[0]] + " " + values[mathOperatorsIndex[1]]);

        int firstNumber = parseFirstNumber(values, mathOperatorsIndex[0]);
        System.out.println(firstNumber);
        int secondNumber = parseSecondNumber(values, mathOperatorsIndex);
        System.out.println(secondNumber);
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

    public static int[] parseMathOperator(String[] values) {
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
        return new int[]{index1, index2};
    }

    public static int parseFirstNumber(String[] values, int index) {
        StringBuilder firstNumberString = new StringBuilder();
        for (int i = 0; i < index; i++) {
            firstNumberString.append(values[i]);
        }
        return Integer.parseInt(firstNumberString.toString());
    }

    public static int parseSecondNumber(String[] values, int[] indexes) {
        int start = indexes[0];
        int end = indexes[1];
        StringBuilder secondNumberString = new StringBuilder();
        for (int i = start + 1; i < end; i++) {
            secondNumberString.append(values[i]);
        }
        return Integer.parseInt(secondNumberString.toString());
    }
}

