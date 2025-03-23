package com.startjava.lession2_3_4.array;

import java.util.Random;

public class Arrays {
    private static int zeroCounter;

    private Arrays() {}

    public static int getZeroCounter() {
        return zeroCounter;
    }

    public static long[] factorials(int[] numbers) {
        if (!isValid(numbers)) {
            return null;
        }

        long[] factorials = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                continue;
            }
            long factorial = 1;
            for (int j = 2; j <= numbers[i]; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    public static int[] fill(int start, int end, int numbersPerLine) {
        if (numbersPerLine < 1) {
            Console.displayError("Количество чисел в строке не должно быть < 1 (" +
                    numbersPerLine + ")");
            return null;
        }
        if (start > end) {
            Console.displayError("Левая граница (" + start + ") > правой (" + end + ")");
            return null;
        }
        int length = (int) (0.75 * (end - start + 1));
        if (length <= 0) {
            Console.displayError("Длина массива должна быть > 0 (" + length + ")");
            return null;
        }

        int[] uniqueNumbers = new int[length];
        int numbersCounter = 0;
        Random random = new Random();

        while (numbersCounter < length) {
            int randomNumber = random.nextInt(start, end + 1);
            boolean isUnique = true;
            for (int i = 0; i < numbersCounter; i++) {
                if (uniqueNumbers[i] == randomNumber) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueNumbers[numbersCounter] = randomNumber;
                numbersCounter++;
            }
        }
        java.util.Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    public static boolean isValid(int[] numbers) {
        if (numbers == null) {
            Console.displayError("Передан массив null");
            return false;
        }
        if (numbers.length == 0) {
            Console.displayError("Передан пустой массив");
            return false;
        }
        return true;
    }

    public static float[][] resetFloatsByIndex(int index) {
        int length = 15;
        if (index < 0 || index > length - 1) {
            Console.displayError("Индекс массива выходит за пределы массива " +
                    "(введено значение: " + index + ", допустимо: [0; " + (length - 1) + "])");
            return null;
        }

        float[] floats = new float[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            floats[i] = random.nextFloat();
        }

        float[] changed = new float[length];
        float limit = floats[index];
        for (int i = 0; i < length; i++) {
            changed[i] = floats[i] > limit ? 0 : floats[i];
        }
        zeroCounter = 0;

        for (float value : changed)
            if (value == 0) {
                zeroCounter++;
            }

        return new float[][] {floats, changed};
    }

    public static int[] reverse(int[] numbers) {
        if (!isValid(numbers)) {
            return null;
        }

        int[] reversed = new int[numbers.length];
        int index = numbers.length;
        for (int number : numbers) {
            reversed[--index] = number;
        }
        return reversed;
    }

    public static StringBuilder triangle(char start, char end, boolean ascending) {
        if (start > end) {
            Console.displayError("левая граница (" + start + ") > (" + end + ")\n");
            return null;
        }

        int triangleHeight = end - start + 1;
        char startPrint = ascending ? end : start;

        StringBuilder triangle = new StringBuilder();
        for (int i = 0; i < triangleHeight; i++) {
            char currentChar = (char) (ascending ? startPrint - i : startPrint + i);
            triangle.append(" ".repeat(Math.max(0, (triangleHeight - 1) - i)))
                    .append(String.valueOf(currentChar).repeat(2 * i + 1))
                    .append("\n");
        }
        return triangle;
    }

    public static String typewriter(String text) {
        if (text == null || text.isEmpty()) {
            Console.displayError("Передана пустая строка, либо null");
            return null;
        }
        String[] words = text.split(" ");
        String longest = words[0];
        String shortest = words[0];
        int shortIndex = 0;
        int longIndex = 0;

        for (int i = 0; i < words.length; i++) {
            String cleanWord = words[i].replaceAll("\\p{P}", "");
            if (shortest.length() > cleanWord.length()) {
                if (cleanWord.isEmpty()) {
                    continue;
                }
                shortest = cleanWord;
                shortIndex = i;
            }
            if (longest.length() < cleanWord.length()) {
                longest = cleanWord;
                longIndex = i;
            }
        }
        StringBuilder result = new StringBuilder();

        int start = Math.min(shortIndex, longIndex);
        int end = Math.max(shortIndex, longIndex);
        for (int i = 0; i < words.length; i++) {
            if (i < start || i > end) {
                result.append(words[i]).append(" ");
            }
            if (i >= start && i <= end) {
                result.append(words[i].toUpperCase()).append(" ");
            }
        }
        return result.toString();
    }
}