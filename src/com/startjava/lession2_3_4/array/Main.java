package com.startjava.lession2_3_4.array;

public class Main {
    public static void main(String[] args) {
        reverseArray(1, 2, 3, 4, 5, -6, 1, 8);
        calculateFactorial(7, -1, 0, 1, 2, -5, 5, 8);
        fillUniqueNumbers(-30, -10, 8);
        resetExceedingValues(13);
        drawTriangle('0', '9', false);
    }

    public static void reverseArray(int... original) {
        Console.displayHeader("Реверс массива");
        int[] reversed = Arrays.reverse(original);
        Console.printReversed(original, reversed);
    }

    public static void calculateFactorial(int... numbers) {
        Console.displayHeader("Вычисление факториала значений массива");
        long[] factorials = Arrays.factorials(numbers);
        Console.printFactorial(numbers, factorials);
    }

    public static void fillUniqueNumbers(int start, int end, int numbersPerLine) {
        Console.displayHeader("Заполнение массива уникальными значениями");
        int[] unique = Arrays.fill(start, end, numbersPerLine);
        Console.printLines(unique, numbersPerLine);
    }

    public static void resetExceedingValues(int index) {
        Console.displayHeader("Обнуление значений массива, превышающих заданное значение");
        float[][] values = Arrays.createAndReset(index);
        Console.printFloatsLines(values, index);
    }

    public static void drawTriangle(char start, char end, boolean ascending) {
        Console.displayHeader("Вывод символов в виде треугольника");
        StringBuilder triangle = Arrays.triangle(start, end, ascending);
        Console.draw(triangle);
    }
}


//Scanner scanner = new Scanner(System.in);
//String userChoose = "yes";
//String[] mainMenu = {
//        "1. Реверс массива", "2. Вычисление факториала значений массива"};
//        while (userChoose.equals("yes")) {
//        System.out.print("Введите номер функции, которую хотите выполнить: ");
//
//        }
