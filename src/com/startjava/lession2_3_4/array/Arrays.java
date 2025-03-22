package com.startjava.lession2_3_4.array;

import java.util.Random;

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

    public static long[] factorials(int[] numbers) {
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

    public static int[] fill(int start, int end, int numbersPerLine) {
        if (numbersPerLine < 1) {
            Console.displayError("Количество чисел в строке не должно быть < 1 (" +
                    numbersPerLine + ")");
            return null;
        }
        if (start > end) {
            Console.displayError("Левая граница (" + start + ") > правой (" + end + ")\n");
            return null;
        }
        int length = (int) (0.75 * (end - start + 1));
        if (length <= 0) {
            Console.displayError("Длина массива должна быть > 0 (" + length + ")\n");
            return null;
        }
        int[] uniqueNumbers = new int[length];
        int numbersCounter = 0;

        while (numbersCounter < length) {
            Random random = new Random();
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

    public static float[][] createAndReset(int index) {
        int length = 15;
        if (index < 0 || index > length) {
            Console.displayError("Индекс массива выходит за пределы массива");
            return null;
        }

        float[] floats = new float[length];
        Random random = new Random();
        for (int i = 0; i < floats.length; i++) {
            floats[i] = random.nextFloat();
        }

        float[] changed = new float[floats.length];
        float limit = floats[index];
        for (int i = 0; i < floats.length; i++) {
            if (floats[i] > limit) {
                changed[i] = 0;
                continue;
            }
            changed[i] = floats[i];
        }
        return new float[][] {floats, changed};
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
}

//
//public static boolean setFunction(int number) {
//    switch (number) {
//        case 1:
//        case 2:
//        case 3:
//        case 4:
//        case 5:
//        case 6:
//            return true;
//        default:
//            Console.displayError("Вы указали неверное значение");
//            return false;
//    }
//}
