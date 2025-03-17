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
        System.out.println("   До реверса: " + Arrays.toString(numbers));
        System.out.println("После реверса: " + Arrays.toString(reversed) + "\n");
    }
}
