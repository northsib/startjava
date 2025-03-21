package com.startjava.lession2_3_4.array;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        reverseArray(8, 9, 0, -2, -5, 1, 5);
        calculateFactorial(7, -1, 0, 1, 2, -5, 5, 8);
    }

    public static void reverseArray(int... original) {
        Console.displayHeader("Реверс массива");
        int[] reversed = Arrays.reverse(original);
        Console.printReversed(original, reversed);
    }

    public static void calculateFactorial(int... numbers) {
        Console.displayHeader("Вычисление факториала значений массива");
        long[] factorials = Arrays.calculate(numbers);
        Console.printFactorial(numbers, factorials);
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
