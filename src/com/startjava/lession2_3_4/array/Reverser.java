package com.startjava.lession2_3_4.array;

import java.util.Arrays;

public class Reverser {
    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] reversed = reverse(emptyArray);
        printResult(emptyArray, reversed);

        int[] nullArray = null;
        reversed = reverse(nullArray);
        printResult(nullArray, reversed);

        int[] array4 = {6, 8, 9, 1};
        reversed = reverse(array4);
        printResult(array4, reversed);

        int[] array7 = {13, 8, 5, 3, 2, 1, 1};
        reversed = reverse(array7);
        printResult(array7, reversed);
    }

    private static int[] reverse(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        if (numbers.length == 0) {
            return numbers;
        }

        int[] reversed = new int[numbers.length];
        int index = numbers.length;
        for (int number : numbers) {
            reversed[--index] = number;
        }
        return reversed;
    }

    private static void printResult(int[] numbers, int[] reversed) {
        String originalOutput = "До реверса: " + Arrays.toString(numbers) + "\n";
        String reverseOutput = "После реверса: " + Arrays.toString(reversed) + "\n";

        int padding = reverseOutput.length();

        System.out.printf("%" + padding + "s", originalOutput);
        System.out.println(reverseOutput);
    }
}
