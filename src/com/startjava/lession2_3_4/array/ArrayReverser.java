package com.startjava.lession2_3_4.array;

public class ArrayReverser {
    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] nullArray = null;
        int[] array4 = {6, 8 ,9, 1};
        int[] array7 = {13, 8, 5, 3, 2, 1, 1};
        printArray(emptyArray);
        printArray(nullArray);
        System.out.printf("%16s", "До реверса: [");
        printArray(array4);
        System.out.print("]\n");
        int[] reversed = reverseArray(array4);
        System.out.print("После реверса: [");
        printArray(reversed);
        System.out.printf("%s%n%16s", "]", "До реверса: [");
        printArray(array7);
        System.out.print("]\n");
        reversed = reverseArray(array7);
        System.out.print("После реверса: [");
        printArray(reversed);
        System.out.print("]\n");
    }

    private static void printArray(int[] numbers) {
        if (numbers == null) {
            System.out.println("null");
            return;
        }
        if (numbers.length == 0) {
            System.out.println("Массив нулевой длины");
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < (numbers.length - 1)) {
                System.out.print(", ");
            }
        }
    }

    private static int[] reverseArray(int[] numbers) {
        int[] reversed = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[(numbers.length - 1) - i];
        }
        return reversed;
    }
}
