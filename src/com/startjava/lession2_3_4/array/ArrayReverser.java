package com.startjava.lession2_3_4.array;

import java.util.Arrays;

public class ArrayReverser {
    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] reverseEmpty = reverse(emptyArray);
        int[] nullArray = null;
        int[] reverseNull = reverse(nullArray);
        int[] array4 = {6, 8 ,9, 1};
        int[] reverse4 = reverse(array4);
        int[] array7 = {13, 8, 5, 3, 2, 1, 1};
        int[] reverse7 = reverse(array7);

        System.out.println("Вызовем пустой массив, выполним его реверс и выведем результат на экран: ");
        System.out.printf("%18s", "До реверса: " + Arrays.toString(emptyArray)+ "\n");
        System.out.println("После реверса: " + Arrays.toString(reverseEmpty));

        System.out.println("\nВызовем массив \"null\", выполним его реверс и выведем результат на экран: ");
        System.out.printf("%20s", "До реверса: " + Arrays.toString(nullArray)+ "\n");
        System.out.println("После реверса: " + Arrays.toString(reverseNull));

        System.out.println("\nВызовем массив из 4 заданных элементов, " +
                "выполним его реверс и выведем результат на экран: ");
        System.out.printf("%28s", "До реверса: " + Arrays.toString(array4) + "\n");
        System.out.print("После реверса: " + Arrays.toString(reverse4) + "\n");

        System.out.println("\nВызовем массив из 7 заданных элементов, " +
                "выполним его реверс и выведем результат на экран: ");
        System.out.printf("%38s", "До реверса: " + Arrays.toString(array7) + "\n");
        System.out.print("После реверса: " + Arrays.toString(reverse7) + "\n");
    }

    private static int[] reverse(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        if (numbers.length == 0) {
            return numbers;
        }

        int[] reversed = new int[numbers.length];
        int index = 0;
        for (int number : numbers) {
            reversed[numbers.length - 1 - index] = number;
            index++;
        }
        return reversed;
    }
}
