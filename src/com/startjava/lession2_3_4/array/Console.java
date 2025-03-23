package com.startjava.lession2_3_4.array;

import java.util.Arrays;

public class Console {
    private Console() {}

    public static void displayBeforeAfter(int[] numbers, int[] reversed) {
        if (!isValid(numbers)) {
            return;
        }
        System.out.print("   До реверса: ");
        printIntegers(numbers, numbers.length, "%d");
        System.out.print("После реверса: ");
        printIntegers(reversed, reversed.length, "%d");
    }

    public static void displayError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public static void displayHeader(String header) {
        System.out.println("--- " + header + " ---\n");
    }

    public static void displayValueLimiter(float[][] values, int index) {
        if (values == null || values.length == 0) {
            return;
        }
        int numberPerLine = 8;
        System.out.println("Исходный массив: ");
        printFloats(values[0], numberPerLine);
        System.out.println("Измененный массив: ");
        printFloats(values[1], numberPerLine);
        System.out.printf("Значение ячейки по переданному индексу: %.3f%n", values[0][index]);
        System.out.println("Количество обнуленных ячеек - " +
                com.startjava.lession2_3_4.array.Arrays.getZeroCounter());
    }

    public static void draw(StringBuilder triangle) {
        if (triangle == null) {
            return;
        }
        System.out.println(triangle);
    }

    public static boolean isValid(int[] numbers) {
        return numbers != null && numbers.length > 0;
    }

    public static <T> void print(T[] array, int numbersPerLine, String format) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (i > 0 && (i % numbersPerLine) == 0) {
                System.out.println();
            }
            System.out.printf(format + "%s", array[i], (i < array.length - 1) ? ", " : "");
        }
        System.out.println();
    }

    public static void printFactorial(int[] original, long[] factorials) {
        if (!isValid(original)) {
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
    }

    public static void printFloats(float[] floats, int numbersPerLine) {
        if (floats == null || floats.length == 0) {
            return;
        }
        Float[] floatObjects = new Float[floats.length];
        for (int i = 0; i < floats.length; i++) {
            floatObjects[i] = floats[i];
        }
        print(floatObjects, numbersPerLine, "%.3f");
    }

    public static void printIntegers(int[] numbers, int numbersPerLine, String format) {
        if (!isValid(numbers)) {
            return;
        }
        Integer[] integerObjects = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        print(integerObjects, numbersPerLine, format);
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
