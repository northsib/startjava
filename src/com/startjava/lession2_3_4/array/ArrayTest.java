package com.startjava.lession2_3_4.array;

public class ArrayTest {
    public static void main(String[] args) {
        int[] numbers = new int[6];
        float[] numbers1 = {5.1f, .5f, 200.5f};
        System.out.println(numbers.length);
        System.out.println(numbers1.length);

        for (float number : numbers1) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i * 10;
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        String[] text = new String[3];
        for (String string : text) {
            System.out.println(string);
        }
    }
}
