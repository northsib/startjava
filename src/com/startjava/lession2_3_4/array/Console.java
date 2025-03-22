package com.startjava.lession2_3_4.array;

import java.util.Arrays;

public class Console {
    private Console() {

    }

    public static void displayError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public static void displayHeader(String header) {
        System.out.println("\n--- " + header + " ---\n");
    }

    public static void draw(StringBuilder triangle) {
        if (triangle == null) {
            return;
        }
        System.out.println(triangle);
    }

    public static void printFactorial(int[] original, long[] factorials) {
        if (original == null || original.length == 0) {
            return;
        }
        StringBuilder factorialExpression = new StringBuilder();
        for (int i = 0; i < original.length; i++) {
            if (factorials[i] == 1) {
                System.out.println(original[i] + "! = 1");
                continue;
            }
            if (factorials[i] == 0) {
                displayError("факториал " + original[i] + "! не определен");
                continue;
            }
            factorialExpression.append(original[i]).append("! = ");
            for (int j = 1; j <= original[i]; j++) {
                factorialExpression.append(j > 1 ? " * " + j : j);
            }
            System.out.println(factorialExpression.append(" = ").append(factorials[i]));
            factorialExpression.setLength(0);
        }
        System.out.println();
    }

    public static void printFloats(float[] floats, int numbersPerLine) {
        if (floats == null) {
            return;
        }
        for (int i = 0; i < floats.length; i++) {
            if (i > 0 && i % numbersPerLine == 0) {
                System.out.println();
            }
            System.out.printf("%.3f%s", floats[i], "");
            if (i < (floats.length - 1)) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void printFloatsLines(float[][] values, int index) {
        if (values == null) {
            return;
        }
        int numberPerLine = 8;
        System.out.print("\nИсходный массив: ");
        printFloats(values[0], numberPerLine);
        System.out.print("Измененный массив: ");
        printFloats(values[1], numberPerLine);
        System.out.printf("Значение ячейки по переданному индексу: %.3f%n", (float) values[0][index]);
        int zeroCounter = 0;
        for (float value : values[1])
            if (value == 0) {
                zeroCounter++;
            }
        System.out.println("Количество обнуленных ячеек - " + zeroCounter);
    }

    public static void printLines(int[] numbers, int numbersPerLine) {
        if (numbers == null) {
            return;
        }
        System.out.println();
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && (i % numbersPerLine) == 0) {
                System.out.println();
            }
            System.out.printf("%3d%s", numbers[i], (i < numbers.length - 1) ? ", " : "");
        }
        System.out.println();
    }

    public static void printReversed(int[] numbers, int[] reversed) {
        if (numbers != null && numbers.length != 0) {
            System.out.print("\n   До реверса: " + Arrays.toString(numbers));
            System.out.print("После реверса: " + Arrays.toString(reversed));
        }
    }

    public static void printTypewriterEffect(String text) throws InterruptedException {
        if (text == null || text.isEmpty()) {
            return;
        }
        char[] chars = text.toCharArray();
        for (char symbols : chars) {
            System.out.print(symbols);
            Thread.sleep(100);
        }
        System.out.println();
    }
}
