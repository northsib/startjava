package com.startjava.lession2_3_4.array;

public class Arrays {
    private Arrays() {

    }

    public static int[] reverse(int[] numbers) {
        if (numbers == null) {
            Console.displayError("Передан массив null");
            return null;
        }
        if (numbers.length == 0) {
            Console.displayError("Передан пустой массив");
            return numbers;
        }

        int[] reversed = new int[numbers.length];
        int index = numbers.length;
        for (int number : numbers) {
            reversed[--index] = number;
        }
        return reversed;
    }

    public static long[] calculate(int... numbers) {
        if (numbers == null) {
            Console.displayError("Передан массив null");
            return null;
        }
        if (numbers.length == 0) {
            Console.displayError("Передан пустой массив");
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

    public static boolean setFunction(int number) {
        switch (number) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                Console.displayError("Вы указали неверное значение");
                return false;
        }
    }
}
